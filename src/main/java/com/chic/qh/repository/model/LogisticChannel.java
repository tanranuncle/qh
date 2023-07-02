package com.chic.qh.repository.model;

import javax.annotation.Generated;

/**
 * Database Table Remarks:
 *   物流渠道表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table qh_logistic_channel
 */
public class LogisticChannel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.rec_id")
    private Integer recId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.code")
    private String code;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.company")
    private String company;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cut_off_time")
    private String cutOffTime;

    /**
     * Database Column Remarks:
     *   耗时说明
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cost_time")
    private String costTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.rec_id")
    public Integer getRecId() {
        return recId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.rec_id")
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.code")
    public String getCode() {
        return code;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.code")
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.company")
    public String getCompany() {
        return company;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.company")
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cut_off_time")
    public String getCutOffTime() {
        return cutOffTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cut_off_time")
    public void setCutOffTime(String cutOffTime) {
        this.cutOffTime = cutOffTime == null ? null : cutOffTime.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cost_time")
    public String getCostTime() {
        return costTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cost_time")
    public void setCostTime(String costTime) {
        this.costTime = costTime == null ? null : costTime.trim();
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recId=").append(recId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", company=").append(company);
        sb.append(", cutOffTime=").append(cutOffTime);
        sb.append(", costTime=").append(costTime);
        sb.append("]");
        return sb.toString();
    }
}