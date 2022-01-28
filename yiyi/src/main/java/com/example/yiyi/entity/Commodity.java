package com.example.yiyi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品信息表(Commodity)实体类
 *
 * @author 李二帅
 * @since 2022-01-28 21:31:58
 */
@Data
public class Commodity implements Serializable {
    private static final long serialVersionUID = 339915500436921314L;
    /**
     * 商品ID
     */
    private Long commodityId;
    /**
     * 发布用户ID
     */
    private Long commodityUserId;
    /**
     * 商品分类ID
     */
    private Long commodityTypeId;
    /**
     * 商品照片路径
     */
    private String commodityPicture;
    /**
     * 商品描述
     */
    private String commodityDescribe;
    /**
     * 商品价格
     */
    private Float commodityPrice;
    /**
     * 商品名称
     */
    private String commodityName;
}
