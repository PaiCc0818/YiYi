package com.example.yiyi.service.impl;

import com.example.yiyi.entity.Message;
import com.example.yiyi.mapper.MessageMapper;
import com.example.yiyi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言信息表(Message)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:02
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    @Override
    public Message queryById(Long messageId) {
        return this.messageMapper.queryById(messageId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Message> queryAllByLimit(int offset, int limit) {
        return this.messageMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message insert(Message message) {
        this.messageMapper.insert(message);
        return message;
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message update(Message message) {
        this.messageMapper.update(message);
        return this.queryById(message.getMessageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long messageId) {
        return this.messageMapper.deleteById(messageId) > 0;
    }
}
