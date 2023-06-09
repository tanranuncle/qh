package com.chic.qh.service.quote;

import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillingWeight {
    private final Integer actWeight;
    private final Integer volWeight;
    private final WeightType weightType;

    public BillingWeight(Integer actWeight, Integer volWeight, WeightType weightType) {
        this.actWeight = actWeight;
        this.volWeight = volWeight;
        this.weightType = weightType;
    }

    public Integer getActWeight() {
        return actWeight;
    }

    public Integer getVolWeight() {
        return volWeight;
    }

    public WeightType getWeightType() {
        return weightType;
    }

    public Integer getValue(){
        Integer value;
        switch (this.weightType){
            case ACTUAL_WEIGHT:
                value = actWeight;
                break;
            case VOL_WEIGHT:
                value = volWeight;
                break;
            default:
                throw new RuntimeException("unknow weight type");
        }
        return value;
    }

    private static final BigDecimal kiloRate = new BigDecimal("0.001");

    //decimal value 返回kg单位的重量，保留3位精度
    public static BigDecimal getDecimalValue(Integer value){
        if(value == null){
            return null;
        }
        return new BigDecimal(value).multiply(kiloRate).setScale(3, RoundingMode.HALF_UP);
    }

    public static BillingWeight build(BigDecimal orderWeight, @Nullable VolumetricWeight volWeight){
        Integer gramOrderWeight = orderWeight.multiply(new BigDecimal("1000")).intValue();
        if(volWeight == null){
            return new BillingWeight(gramOrderWeight, null, WeightType.ACTUAL_WEIGHT);
        }
        //体积重计算精确到克(g), 订单实重单位是千克(kg),需要把单位统一再进行比较
        //如果 体积重 大于 实重 则使用体积重
        if(new BigDecimal(volWeight.getValue()).compareTo(new BigDecimal(gramOrderWeight)) > 0){
            return new BillingWeight(gramOrderWeight, volWeight.getValue(), WeightType.VOL_WEIGHT);
        }else{
            return new BillingWeight(gramOrderWeight, volWeight.getValue(), WeightType.ACTUAL_WEIGHT);
        }
    }
}
