package com.chic.qh.service.goods.dto;

import com.chic.qh.domain.dal.model.GoodsComment;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class GoodsCommentDTO {
    private Integer recId;
    private Integer goodsId;
    private String content;
    private String user;
    private String avatar;
    private Integer createdAt;

    public static GoodsCommentDTO build(GoodsComment commentPO){
        GoodsCommentDTO dto = new GoodsCommentDTO();
        BeanUtils.copyProperties(commentPO, dto);
        dto.setAvatar("https://xsgames.co/randomusers/avatar.php?g=pixel&key=" + dto.user);
        return dto;
    }
}