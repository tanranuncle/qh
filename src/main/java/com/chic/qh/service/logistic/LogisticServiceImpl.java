package com.chic.qh.service.logistic;

import com.chic.qh.repository.mapper.LogisticChannelDetailDynamicSqlSupport;
import com.chic.qh.repository.mapper.LogisticChannelDetailMapper;
import com.chic.qh.repository.mapper.LogisticChannelDynamicSqlSupport;
import com.chic.qh.repository.mapper.LogisticChannelMapper;
import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.repository.model.LogisticChannelDetail;
import com.chic.qh.service.logistic.dto.ChannelDetailExcelVO;
import com.chic.qh.service.logistic.dto.LogisticConfigDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.ArrayListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LogisticServiceImpl implements LogisticService{

    @Autowired
    private LogisticChannelMapper logisticChannelMapper;
    @Autowired
    private LogisticChannelDetailMapper logisticChannelDetailMapper;
    @Override
    public Page<LogisticChannel> getChannelList(String _company, String _code, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() ->
                logisticChannelMapper.select(c -> c
                        .where(LogisticChannelDynamicSqlSupport.company, SqlBuilder.isEqualToWhenPresent(_company))
                        .and(LogisticChannelDynamicSqlSupport.code, SqlBuilder.isEqualToWhenPresent(_code))
                        .orderBy(LogisticChannelDynamicSqlSupport.recId.descending())));
    }

    @Override
    public void addChannel(LogisticChannel logisticChannel) {
        logisticChannelMapper.insert(logisticChannel);
    }

    @Override
    public List<LogisticConfigDTO> getChannelDetail(Integer channelId) {
        Integer index = 1;
        ArrayListMultimap<LogisticChannelDetailUniKey, LogisticChannelDetail> channelDetailListMap = getChannelDetailListMap(channelId);
        List<LogisticConfigDTO> dtoList = new ArrayList<>(channelDetailListMap.keySet().size());

        for (LogisticChannelDetailUniKey uniKey : channelDetailListMap.keySet()) {
            List<LogisticChannelDetail> details = channelDetailListMap.get(uniKey);
            LogisticConfigDTO dto = new LogisticConfigDTO();
            dto.setId(index);
            dto.setCountry(uniKey.getCountry());
            dto.setShippingTime(uniKey.getShippingTime());
            dto.setVolWeightRate(uniKey.getVolWeightRate());

            List<LogisticConfigDTO.Item> itemList = new ArrayList<>(details.size());
            details.forEach(x->{
                LogisticConfigDTO.Item item = new LogisticConfigDTO.Item();
                item.setId(x.getRecId());
                item.setLeft(x.getWeightLeft());
                item.setRight(x.getWeightRight());
                item.setShippingFee(x.getShippingFee());
                item.setExtraFee(x.getExtraFee());
                itemList.add(item);
            });
            dto.setItems(itemList);

            dtoList.add(dto);
            index++;
        }

        return dtoList;
    }

    private ArrayListMultimap<LogisticChannelDetailUniKey, LogisticChannelDetail> getChannelDetailListMap(Integer channelId){
        List<LogisticChannelDetail> channelDetails = logisticChannelDetailMapper.select(c ->
                c.where(LogisticChannelDetailDynamicSqlSupport.channelId, SqlBuilder.isEqualTo(channelId))
                        .orderBy(LogisticChannelDetailDynamicSqlSupport.weightLeft,LogisticChannelDetailDynamicSqlSupport.recId)
        );

        ArrayListMultimap<LogisticChannelDetailUniKey, LogisticChannelDetail> channelDetailListMap = ArrayListMultimap.create();
        channelDetails.forEach(x->{
            channelDetailListMap.put(new LogisticChannelDetailUniKey(x.getCountry(), x.getShippingTime(), x.getVolWeightRate()), x);
        });
        return channelDetailListMap;
    }


    @Override
    public void processImportChannelDetail(Integer channelId, List<ChannelDetailExcelVO> dataList) {
        if(CollectionUtils.isEmpty(dataList)){
            log.warn("没有导入有效的物流渠道详情数据!channelId:{}" , channelId);
            return;
        }
        List<LogisticChannelDetail> detailList = dataList.stream().map(x -> {
            LogisticChannelDetail detail = new LogisticChannelDetail();
            BeanUtils.copyProperties(x, detail);
            detail.setChannelId(channelId);
            return detail;
        }).collect(Collectors.toList());
        //删除原渠道详情
        logisticChannelDetailMapper.delete(c->c.where(LogisticChannelDetailDynamicSqlSupport.channelId, SqlBuilder.isEqualTo(channelId)));
        //插入新的渠道详情
        logisticChannelDetailMapper.insertMultiple(detailList);
    }

    @Override
    public List<ChannelDetailExcelVO> exportChannelDetail(Integer channelId) {
        ArrayListMultimap<LogisticChannelDetailUniKey, LogisticChannelDetail> channelDetailListMap = getChannelDetailListMap(channelId);
        List<ChannelDetailExcelVO> voList = new ArrayList<>();
        channelDetailListMap.keySet().forEach(x->{
            List<LogisticChannelDetail> details = channelDetailListMap.get(x);
            details.forEach(c->{
                ChannelDetailExcelVO vo = new ChannelDetailExcelVO();
                BeanUtils.copyProperties(c, vo);
                voList.add(vo);
            });
        });
        return voList;
    }

    @Override
    public LogisticChannel getChannelInfo(Integer channelId) {
        return logisticChannelMapper.selectByPrimaryKey(channelId).orElse(null);
    }

    @Override
    public int deleteChannel(Integer channelId) {
        return logisticChannelMapper.deleteByPrimaryKey(channelId);
    }

    @Override
    public int updateChannel(LogisticChannel logisticChannel) {
        return logisticChannelMapper.updateByPrimaryKeySelective(logisticChannel);
    }

    @Override
    public ChannelConfig getChannelConfig(Integer channelId) {
        LogisticChannel channelInfo = getChannelInfo(channelId);
        if(channelInfo == null){
            return null;
        }
        return new ChannelConfig(channelInfo, getChannelDetailListMap(channelId));
    }
}
