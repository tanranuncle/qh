package com.chic.qh.service.goods.vo;

import lombok.Data;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:44
 */
@Data
public class SkuVO {

    private Integer skuId;

    private Integer goodsId;

    private String skuName;

    private String skuNameEn;

    //供应商名称
    private String suppName;

    private String suppSkuId;

    private String link;

    //长度（cm）
    private Integer length;

    private Integer width;

    private Integer height;

    //面积
    private BigDecimal area;
    //重量
    private BigDecimal weight;
    //体积重
    private BigDecimal volumeWeight;
    //采购价
    private BigDecimal purPrice;

    private String color;

    private String size;

    private Integer gmtCreated;

    private Integer gmtModify;

    private String remark;

    private String skuImage;

    //父级skuId
    private Integer parentId;

    //店小蜜skuId
    private String dxmSkuId;

    //子sku列表
    private List<SkuVO> children;

}
