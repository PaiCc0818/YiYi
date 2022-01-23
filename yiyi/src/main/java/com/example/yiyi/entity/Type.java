package com.example.yiyi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品分类表(Type)实体类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:03
 */
@Data
public class Type implements Serializable {
    private static final long serialVersionUID = 281642663771470167L;
    /**
     * 分类ID
     */
    private Long typeId;
    /**
     * 分类名称
     */
    private String typeName;
    /**
     * 分类创建时间
     */
    private Date typeCreateTime;

    /**
     * 该分类中所有的商品
     */
    private List<Commodity> commodityList;
}
