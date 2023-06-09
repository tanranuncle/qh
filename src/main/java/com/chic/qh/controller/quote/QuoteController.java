package com.chic.qh.controller.quote;

import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.support.web.RespWrap;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 报价
 * @author: xumingwei
 * @date: 2023—04—07 14:30
 */
@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private QuoteService quoteService;
    @RespWrap
    @GetMapping("/{goodsSn}")
    public QuoteRespDTO quote(@PathVariable("goodsSn") String goodsSn,
                              @RequestParam(name = "country", defaultValue = "US") String country,
                              @RequestParam(name = "quantity", defaultValue="1") Integer quantity,
                              @RequestParam(value = "skuId", required = false) Integer skuId) {
        GoodsVO goodsVO = goodsService.getGoodsBySn(goodsSn);
        QuoteRespDTO dto = new QuoteRespDTO();
        dto.setGoodsVo(goodsVO);
        dto.setCountry(country);
        dto.setQuantity(quantity);
        SkuVO skuVO = goodsVO.getSkuList().stream()
                .filter(sku -> sku.getSkuId().equals(skuId))
                .findFirst()
                .orElse(goodsVO.getSkuList().get(0));
        dto.setCurrentSku(skuVO);
        dto.setResult(quoteService.quote(countryMap.get(country), goodsVO, skuVO, quantity));
        return dto;
    }

    private static final Map<String, String> countryMap = new HashMap();
    static{
        countryMap.put("US", "美国");
        countryMap.put("CA", "加拿大");
        countryMap.put("AU", "澳大利亚");
        countryMap.put("GB", "英国");
        countryMap.put("DE", "德国");
        countryMap.put("FR", "法国");
    }
}
