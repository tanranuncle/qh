package com.chic.qh.repository.model;

import javax.annotation.Generated;

/**
 * Database Table Remarks:
 *   商品各国运输线路配置
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table qh_goods_channel
 */
public class GoodsChannel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.rec_id")
    private Integer recId;

    /**
     * Database Column Remarks:
     *   商品id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.goods_id")
    private Integer goodsId;

    /**
     * Database Column Remarks:
     *   ios国家码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.country_code")
    private String countryCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.channel_code")
    private String channelCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.updated_at")
    private Integer updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.rec_id")
    public Integer getRecId() {
        return recId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.rec_id")
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.goods_id")
    public Integer getGoodsId() {
        return goodsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.goods_id")
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.channel_code")
    public String getChannelCode() {
        return channelCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.channel_code")
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.updated_at")
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.updated_at")
    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recId=").append(recId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append("]");
        return sb.toString();
    }
}