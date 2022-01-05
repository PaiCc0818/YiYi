package com.example.yiyi.controller;

import com.example.yiyi.entity.Message;
import com.example.yiyi.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 留言信息表(Message)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:02
 */
@Controller
@ResponseBody
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Message selectOne(Long id) {
        return this.messageService.queryById(id);
    }

}