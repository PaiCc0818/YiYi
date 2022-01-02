package com.example.yiyi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品信息表(Commodity)实体类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:01
 */
@Data
public class Commodity implements Serializable {
    private static final long serialVersionUID = -18515102200390924L;
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
}
