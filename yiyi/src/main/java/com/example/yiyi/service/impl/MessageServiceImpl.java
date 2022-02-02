package com.example.yiyi.service.impl;

import com.example.yiyi.entity.Message;
import com.example.yiyi.mapper.MessageMapper;
import com.example.yiyi.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 留言信息表(Message)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:02
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    /**
     * 查询所有评论
     *
     * @param CommodityId 商品ID
     * @return 评论列表
     */
    @Override
    public List<Message> queryAllByCommodityId(Long CommodityId) {
        List<Message> result = new ArrayList<>();
        // 通过商品id查询所有父评论
        List<Message> messages = this.messageMapper.queryAllByCommodityId(CommodityId);
        for (Message message : messages) {
            // 遍历所有父评论查询该评论的所有子评论
            List<Message> messageList = messageMapper.queryParentMessageBeyId(message.getMessageId());
            message.setChildMessages(messageList);
            result.add(message);
        }
        return result;
    }

    /**
     * 插入数据
     *
     * @param message 实例对象
     * @return 返回插入数据数
     */
    @Override
    public int insert(Message message) {
        return this.messageMapper.insert(message);
    }
}
