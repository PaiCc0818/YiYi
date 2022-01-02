package com.example.yiyi.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 留言信息表(Message)实体类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:02
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = -72230233285878378L;
    /**
     * 留言ID
     */
    private Long messageId;
    /**
     * 留言商品ID
     */
    private Long messageCommodityId;
    /**
     * 留言用户ID
     */
    private Long messageUserId;
    /**
     * 父留言ID
     */
    private Long messageParentId;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 留言创建时间
     */
    private Date messageCreateTime;
}
