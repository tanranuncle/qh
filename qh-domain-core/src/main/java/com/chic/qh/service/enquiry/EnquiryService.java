package com.chic.qh.service.enquiry;

import com.chic.qh.service.enquiry.dto.*;
import com.chic.qh.service.enquiry.vo.EnquiryOrderListVO;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:49
 */
public interface EnquiryService {

    EnquiryOrderListVO queryList(EnquiryOrderQueryDTO dto);

    void addEnquiryOrder(EnquiryOrderAddDTO dto);

    void addEnquiryOrderGoods(EnquiryOrderGoodsAddDTO dto);

    void deleteEnquiryOrderGoods(EnquiryOrderGoodsDeleteDTO dto);

    void updateGoodsSn(EnquiryOrderUpdateDTO dto);
}