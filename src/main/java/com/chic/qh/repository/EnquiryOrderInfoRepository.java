package com.chic.qh.repository;

import com.chic.qh.repository.mapper.EnquiryOrderInfoDynamicSqlSupport;
import com.chic.qh.repository.mapper.EnquiryOrderInfoMapper;
import com.chic.qh.repository.model.EnquiryOrderInfo;
import com.chic.qh.service.enquiry.dto.EnquiryOrderQueryDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.chic.qh.repository.mapper.EnquiryOrderInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:53
 */
@Repository
public class EnquiryOrderInfoRepository {

    @Autowired
    private EnquiryOrderInfoMapper enquiryOrderInfoMapper;

    public PageInfo<EnquiryOrderInfo> queryPagedList(EnquiryOrderQueryDTO dto) {
        return PageHelper.startPage(dto.getCurrent(), dto.getPageSize()).doSelectPageInfo(
                () -> enquiryOrderInfoMapper.select(c->c
                                .where(enquiryOrderId, isEqualToWhenPresent(dto.getEnquiryOrderId()))
                                .and(enquiryOrderSn, isEqualToWhenPresent(dto.getEnquiryOrderSn()))
                                .and(enquiryOrderName, isLikeWhenPresent(dto.getEnquiryOrderName()))
                                .and(customerInfo, isLikeWhenPresent(dto.getCustomerInfo()))
                                .and(gmtCreated, isGreaterThanOrEqualToWhenPresent(dto.getGmtCreatedStart()))
                                .and(gmtCreated, isLessThanOrEqualToWhenPresent(dto.getGmtCreatedEnd()))
                                .orderBy(gmtCreated.descending())
                        )
        );
    }

    public void saveEnquiryOrder(EnquiryOrderInfo orderInfo) {
        enquiryOrderInfoMapper.insertSelective(orderInfo);
    }

    public EnquiryOrderInfo queryBySn(String _enquiryOrderSn) {
        if(StringUtils.isBlank(_enquiryOrderSn)){
            return null;
        }
        return enquiryOrderInfoMapper.selectOne(c->c.where(enquiryOrderSn, isEqualTo(_enquiryOrderSn))).orElse(null);
    }

    public EnquiryOrderInfo queryById(Integer _enquiryOrderId) {
        return enquiryOrderInfoMapper.selectOne(c->c.where(enquiryOrderId, isEqualTo(_enquiryOrderId))).orElse(null);
    }

    public int deleteEnquiryOrders(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return enquiryOrderInfoMapper.delete(c -> c.where(enquiryOrderId, isIn(ids)));
    }
}
