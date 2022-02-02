package com.example.yiyi.service;

import com.example.yiyi.entity.Message;

import java.util.List;

/**
 * 留言信息表(Message)表服务接口
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:02
 */
public interface MessageService {

    /**
     * 通过商品获取商品评论信息
     *
     * @param CommodityId 商品ID
     * @return 评论列表
     */
    List<Message> queryAllByCommodityId(Long CommodityId);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int insert(Message message);
}
