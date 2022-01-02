package com.example.yiyi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单信息表(Order)实体类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:03
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 572323945501509357L;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 出售者ID
     */
    private Long sellUserId;
    /**
     * 购买者ID
     */
    private Long buyUserId;
}
