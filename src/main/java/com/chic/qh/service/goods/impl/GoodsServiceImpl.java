package com.chic.qh.service.goods.impl;

import com.alibaba.excel.metadata.data.HyperlinkData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.chic.qh.repository.GoodsRepository;
import com.chic.qh.repository.SkuRelationRepository;
import com.chic.qh.repository.model.*;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.dto.*;
import com.chic.qh.service.goods.vo.GoodsListVO;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.service.order.dto.OrderImportDTO;
import com.chic.qh.service.quote.QuoteResult;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.support.utils.ExcelUtils;
import com.github.pagehelper.Page;
import com.google.common.collect.ArrayListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 商品
 * @author: xumingwei
 * @date: 2023—04—09 12:25
 */
@Slf4j
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private SkuRelationRepository skuRelationRepository;

    @Autowired
    private LogisticService logisticService;

    @Autowired
    private QuoteService quoteService;

    @Override
    public boolean exist(Integer goodsId) {
        return goodsRepository.selectByPrimaryKey(goodsId).isPresent();
    }

    @Override
    public GoodsListVO queryList(GoodsQueryDTO dto) {
        Page<Goods> goodsPage = goodsRepository.queryPagedList(dto);
        //build vo
        List<GoodsVO> goodsVOList = goodsPage.getResult()
                .stream().map(x -> buildVO(x)).collect(Collectors.toList());
        return new GoodsListVO(goodsPage.getTotal(), goodsVOList);
    }

    @Override
    public GoodsVO getGoods(Integer goodsId){
        return goodsRepository.selectByPrimaryKey(goodsId).map(x -> buildVO(x))
                .orElseThrow(() -> new NoSuchElementException("找不到id为 " + goodsId + " 的商品"));
    }

    @Override
    public GoodsVO getGoodsBySn(String goodsSn){
        return goodsRepository.selectByGoodsSn(goodsSn).map(x -> buildVO(x))
                .orElseThrow(() -> new NoSuchElementException("找不到Sn为 " + goodsSn + " 的商品"));
    }

    @Override
    public List<GoodsVO> selectBySnList(List<String> snList){
        return goodsRepository.selectBySnList(snList).stream().map(x -> buildVO(x)).collect(Collectors.toList());
    }

    @Override
    public Goods getGoodsPOBySn(String goodsSn){
        return goodsRepository.selectByGoodsSn(goodsSn).orElse(null);
    }

    private GoodsVO buildVO(Goods goodsPo){
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goodsPo, goodsVO);

        List<SkuRelation> skuRelationList = skuRelationRepository.querySkuList(goodsPo.getGoodsId());
        List<SkuVO> skuVOList = buildSkuVOList(skuRelationList);

        goodsVO.setSkuList(skuVOList);

        List<String> imageUrls = new ArrayList<>();
        imageUrls.add(goodsPo.getGoodsImage());
        List<String> skuImages = skuRelationList.stream()
                .map(s -> s.getSkuImage())
                .filter(url -> StringUtils.isNotBlank(url))
                .distinct()
                .collect(Collectors.toList());
        imageUrls.addAll(skuImages);
        goodsVO.setImageUrls(imageUrls.stream().distinct().collect(Collectors.toList()));
        return goodsVO;
    }

    private GoodsSnGenerator goodsSnGen = new GoodsSnGenerator(10);

    @Override
    public void addGoods(GoodsAddUpdateDTO dto) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(dto, goods);
        goods.setGoodsSn(goodsSnGen.get());
        goods.setStatus((byte)1);
        goods.setGmtCreated((int)Instant.now().getEpochSecond());
        //text类型无默认值
        goods.setRemark(StringUtils.isEmpty(dto.getRemark()) ? StringUtils.EMPTY : dto.getRemark());
        goods.setRemarkEn(StringUtils.isEmpty(dto.getRemarkEn()) ? StringUtils.EMPTY : dto.getRemarkEn());

        List<SkuAddUpdateDTO> skuDTOList = dto.getSkuList();
        if(CollectionUtils.isEmpty(skuDTOList)){
            //throw new RuntimeException("商品至少需要包含一个sku");
            //todo: 商品新增暂时给sku空列表
            skuDTOList = new ArrayList<>();
        }

        List<SkuRelation> skuRelationList = new ArrayList<>(skuDTOList.size());
        skuDTOList.forEach(x->{
            SkuRelation skuRelation = new SkuRelation();
            BeanUtils.copyProperties(x, skuRelation);
            skuRelation.setGmtCreated((int)Instant.now().getEpochSecond());
            skuRelationList.add(skuRelation);
        });
        goodsRepository.saveGoods(goods);
        skuRelationList.forEach(x->{
            x.setGoodsId(goods.getGoodsId());
            skuRelationRepository.saveSkuRelation(x);
        });
    }

    @Override
    public void updateGoods(GoodsAddUpdateDTO dto) {
        Goods goods = goodsRepository.getGoods(dto.getGoodsId());
        if(goods == null){
            throw new RuntimeException("商品找不到!goodsId:" + dto.getGoodsId());
        }

        Goods updateGoods = new Goods();
        BeanUtils.copyProperties(dto, updateGoods);
        //text类型无默认值
        goods.setRemark(StringUtils.isEmpty(dto.getRemark()) ? StringUtils.EMPTY : dto.getRemark());
        goods.setRemarkEn(StringUtils.isEmpty(dto.getRemarkEn()) ? StringUtils.EMPTY : dto.getRemarkEn());
        updateGoods.setGmtModify((int)Instant.now().getEpochSecond());
        goodsRepository.updateGoods(updateGoods);

        //todo: 目前商品编辑暂时给sku空列表，不对sku进行编辑
        List<SkuAddUpdateDTO> skuDTOList = dto.getSkuList();
        if(!CollectionUtils.isEmpty(skuDTOList)){
            List<SkuRelation> skuRelationList = new ArrayList<>(skuDTOList.size());
            skuDTOList.forEach(x->{
                SkuRelation skuInfo = new SkuRelation();
                BeanUtils.copyProperties(x, skuInfo);
                skuInfo.setGoodsId(updateGoods.getGoodsId());
                skuInfo.setGmtCreated((int)Instant.now().getEpochSecond());
                skuRelationList.add(skuInfo);
            });
            skuRelationRepository.deleteSkuByGoodsId(updateGoods.getGoodsId());
            skuRelationList.forEach(x->{
                skuRelationRepository.saveSkuRelation(x);
            });
        }

    }

    @Override
    public void deleteGoods(GoodsAddUpdateDTO dto) {
        Goods updateGoods = new Goods();
        updateGoods.setGoodsId(dto.getGoodsId());
        updateGoods.setStatus((byte)3);
        updateGoods.setGmtModify((int)Instant.now().getEpochSecond());
        goodsRepository.updateGoods(updateGoods);
    }

    @Override
    public List<SkuVO> querySkuList(SkuQueryDTO dto) {
        List<SkuRelation> skuRelationList = skuRelationRepository.querySkuList(dto.getGoodsId());
        return buildSkuVOList(skuRelationList);
    }

    private List<SkuVO> buildSkuVOList(List<SkuRelation> skuRelationList){
        List<Integer> skuIds = skuRelationList.stream().map(x -> x.getSkuId()).collect(Collectors.toList());
        ArrayListMultimap<Integer, SkuRelation> childSkuListMap = ArrayListMultimap.create();
        if(CollectionUtils.isNotEmpty(skuIds)) {
            List<SkuRelation> childList = skuRelationRepository.querySkuListByParentIds(skuIds);
            childList.forEach(x->childSkuListMap.put(x.getParentId(), x));
        }
        List<SkuVO> skuVOList = new ArrayList<>(skuRelationList.size());
        skuRelationList.forEach(x->{
            SkuVO skuVO = new SkuVO();
            BeanUtils.copyProperties(x, skuVO);
            List<SkuRelation> childList = childSkuListMap.get(x.getSkuId());
            if(CollectionUtils.isNotEmpty(childList)) {
                List<SkuVO> childSkuVOList = childList.stream().map(childSku -> {
                    SkuVO childSkuVO = new SkuVO();
                    BeanUtils.copyProperties(childSku, childSkuVO);
                    return childSkuVO;
                }).collect(Collectors.toList());
                skuVO.setChildren(childSkuVOList);
            }
            skuVOList.add(skuVO);
        });
        return skuVOList;
    }

    @Override
    public void addSku(SkuAddUpdateDTO dto) {
        SkuRelation skuInfo = new SkuRelation();
        BeanUtils.copyProperties(dto, skuInfo);
        skuInfo.setGmtCreated((int)Instant.now().getEpochSecond());
        skuRelationRepository.saveSkuRelation(skuInfo);
    }

    @Override
    public void updateSku(SkuAddUpdateDTO dto) {
        SkuRelation skuRelation = skuRelationRepository.getSku(dto.getSkuId());
        if(skuRelation == null){
            throw new RuntimeException("sku找不到!skuId:" + dto.getSkuId());
        }
        SkuRelation updateSku = new SkuRelation();
        BeanUtils.copyProperties(dto, updateSku);
        skuRelationRepository.updateSkuRelation(updateSku);
    }

    @Override
    public void deleteSku(SkuAddUpdateDTO dto) {
        skuRelationRepository.deleteSkuBySkuId(dto.getSkuId());
    }

    @Override
    public List<GoodsCommentDTO> getGoodsComments(Integer goodsId, String name) {
        return goodsRepository.getComments(goodsId)
                .stream().map(x -> GoodsCommentDTO.build(x, name))
                .collect(Collectors.toList());
    }

    @Override
    public void addComment(GoodsCommentDTO comment) {
        GoodsComment commentPO = new GoodsComment();
        commentPO.setContent(comment.getContent());
        commentPO.setCreatedAt((int)Instant.now().getEpochSecond());
        commentPO.setGoodsId(comment.getGoodsId());
        commentPO.setUser(comment.getUser());
        commentPO.setStatus((byte)1);
        goodsRepository.addComment(commentPO);
    }

    @Override
    public void deleteComment(Integer commentId, String name) {
        GoodsComment comment = goodsRepository.getComment(commentId);
        if(comment == null){
            throw new RuntimeException("商品记录不存在!commentId:" + commentId);
        }
        if(!comment.getUser().equals(name)){
            throw new RuntimeException("没有权限删除商品记录!commentId:" + commentId);
        }
        goodsRepository.deleteComment(commentId);

    }

    @Override
    public List<SkuListExcelVO> exportSkuList(Integer goodsId) {
        List<SkuRelation> skuRelationList = skuRelationRepository.querySkuList(goodsId);
        List<SkuListExcelVO> voList = new ArrayList<>();
        skuRelationList.forEach(x -> {
            SkuListExcelVO vo = new SkuListExcelVO();
            BeanUtils.copyProperties(x, vo);
            //sku图片
            if(StringUtils.isNotBlank(x.getSkuImage())) {
                try {
                    vo.setUrl(new URL(x.getSkuImage()));
                } catch (MalformedURLException e) {
                    log.warn("sku列表导出：图片不合法:{}", x.getSkuImage(), e);
                }
            }
            //计费体积
            int totalArea = x.getLength() * x.getWidth() * x.getHeight();
            vo.setVolume(totalArea + "cm³(" + x.getLength() + "*" + x.getWidth() + "*" + x.getHeight() + ")");

            //供应商信息
            WriteCellData<String> suppInfo = new WriteCellData<>(x.getSuppName());
            HyperlinkData hyperlinkData = new HyperlinkData();
            suppInfo.setHyperlinkData(hyperlinkData);
            hyperlinkData.setAddress(x.getLink());
            hyperlinkData.setHyperlinkType(HyperlinkData.HyperlinkType.URL);
            vo.setSuppInfo(suppInfo);


            voList.add(vo);
        });
        return voList;
    }

    @Override
    public GoodsChannel getGoodsChannel(Integer goodsId, String countryCode, Byte channelType) {
        return goodsRepository.selectGoodsChannel(goodsId, countryCode, channelType).orElse(null);
    }

    @Override
    public int editOrUpdateGoodsChannel(Integer goodsId, String countryCode, String channelCode, Byte channelType) {
        LogisticChannel channelInfo = logisticService.getChannelInfo(channelCode);
        if(channelInfo == null){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND ,"物流渠道[" +channelCode+ "]不存在!");
        }
        Goods goods = goodsRepository.getGoods(goodsId);
        if(goods == null){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND ,"商品[" +goodsId+ "]不存在!");
        }
        Optional<GoodsChannel> channelOptional = goodsRepository.selectGoodsChannel(goodsId, countryCode, channelType);
        if(channelOptional.isPresent()){
            GoodsChannel channel = channelOptional.get();
            channel.setChannelCode(channelCode);
            channel.setChannelType(channelType);
            channel.setUpdatedAt((int)Instant.now().getEpochSecond());
            return goodsRepository.updateGoodsChannel(channel);
        }else{
            GoodsChannel channel = new GoodsChannel();
            channel.setGoodsId(goodsId);
            channel.setCountryCode(countryCode);
            channel.setChannelCode(channelCode);
            channel.setChannelType(channelType);
            channel.setUpdatedAt((int)Instant.now().getEpochSecond());
            return goodsRepository.addGoodsChannel(channel);
        }
    }

    @Override
    public int batchUpdateGoodsChannel(List<GoodsChannelConfigUpdateDTO> channelConfigs) {
        int i = 0;
        for(GoodsChannelConfigUpdateDTO dto : channelConfigs){
            i += editOrUpdateGoodsChannel(dto.getGoodsId(), dto.getCountryCode(), dto.getChannelCode(), dto.getChannelType());
        }
        return i;
    }

    @Override
    public List<GoodsChannelRespDTO> getGoodsChannelDTOList(Integer goodsId) {
        List<GoodsChannel> channels = goodsRepository.getGoodsChannelList(goodsId);
        List<String> channelCodes = channels.stream().map(GoodsChannel::getChannelCode).collect(Collectors.toList());
        List<LogisticChannel> l = logisticService.getByCodes(channelCodes);
        Map<String, LogisticChannel> channelMap = l.stream().collect(Collectors.toMap(LogisticChannel::getCode, x -> x));
        Map<String, List<GoodsChannel>> group = channels.stream().collect(Collectors.groupingBy(GoodsChannel::getCountryCode));

        return group.entrySet().stream().map(x -> {
            String countryCode = x.getKey();
            List<GoodsChannel> channelList = x.getValue();
            Map<Byte, GoodsChannel> typedChannel = channelList.stream().collect(Collectors.toMap(GoodsChannel::getChannelType, y -> y));
            GoodsChannel channel1 = typedChannel.get((byte)1);
            GoodsChannel channel2 = typedChannel.get((byte)2);
            GoodsChannelRespDTO dto = new GoodsChannelRespDTO();

            dto.setGoodsId(goodsId);
            dto.setCountryCode(countryCode);
            if(channel1 != null) {
                String channelName1 = Optional.ofNullable(channelMap.get(channel1.getChannelCode()))
                        .map(LogisticChannel::getName).orElse("");
                dto.setChannelCode(channel1.getChannelCode());
                dto.setChannelName(channelName1);
            }

            if(channel2 != null) {
                String channelName2 = Optional.ofNullable(channelMap.get(channel2.getChannelCode()))
                        .map(LogisticChannel::getName).orElse("");
                dto.setChannelCode2(channel2.getChannelCode());
                dto.setChannelName2(channelName2);
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<GoodsChannel> getGoodsChannelList(Integer goodsId) {
        return goodsRepository.getGoodsChannelList(goodsId);
    }


    @Override
    public int deleteGoodsChannel(Integer goodsId, String countryCode) {
        return goodsRepository.deleteGoodsChannel(goodsId, countryCode);
    }

    @Override
    public void importSku(MultipartFile file) {
        List<SkuImportDTO> excelList = ExcelUtils.importExcel(file, SkuImportDTO.class, null);
        if (CollectionUtils.isEmpty(excelList)) {
            throw new RuntimeException("excel模版数据为空");
        }
        if(excelList.size() > 5000){
            throw new RuntimeException("单次导入数据最多5000条");
        }
        //zesty的skuId必须存在
        List<Integer> parentIds = excelList.stream()
                .map(SkuImportDTO::getParentId)
                .filter(x -> x != null)
                .collect(Collectors.toList());
        Map<Integer, SkuRelation> idx = goodsRepository.selectSkuByIds(parentIds)
                .stream()
                .collect(Collectors.toMap(SkuRelation::getSkuId, x -> x));
        //店小蜜skuId必须存在
        List<String> dxmSkuIds = excelList.stream()
                .map(SkuImportDTO::getDxmSkuId)
                .filter(x -> StringUtils.isNotBlank(x))
                .collect(Collectors.toList());
        Map<String, SkuRelation> exists = goodsRepository.selectSkuByDxmIds(dxmSkuIds).stream()
                .collect(Collectors.toMap(SkuRelation::getDxmSkuId, x -> x, (v1, v2) -> v1));

        List<SkuRelation> skuList = excelList.stream()
                .filter(x -> x.getParentId()!=null
                        && StringUtils.isNotBlank(x.getDxmSkuId())
                        && idx.containsKey(x.getParentId())
                        && !exists.containsKey(x.getDxmSkuId())
                )
                .map(x -> {
                    SkuRelation parent = idx.get(x.getParentId());
                    SkuRelation po = new SkuRelation();
                    BeanUtils.copyProperties(x, po);
                    po.setGoodsId(parent.getGoodsId());
                    po.setGmtCreated((int)Instant.now().getEpochSecond());
                    return po;
                }).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(skuList)){
            throw new RuntimeException("无有效的数据");
        }
        goodsRepository.insertSkuList(skuList);
    }
}
