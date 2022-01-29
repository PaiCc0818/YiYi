package com.example.yiyi.mapper;

import com.example.yiyi.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 留言信息表(Message)表数据库访问层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:02
 */
@Mapper
public interface MessageMapper {

    /**
     * 通过商品获取商品评论信息
     *
     * @param CommodityId 商品ID
     * @return 评论列表
     */
    List<Message> queryAllByCommodityId(Long CommodityId);

    /**
     * 根据父评论查询所有子评论信息
     *
     * @param parentId 父评论id
     * @return 评论列表
     */
    List<Message> queryParentMessageBeyId(Long parentId);
}

