package com.example.yiyi.controller;

import com.example.yiyi.entity.Message;
import com.example.yiyi.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
     * 通过商品获取商品评论信息
     *
     * @param CommodityId 商品ID
     * @return 评论列表
     */
    @GetMapping("queryAllByCommodityId")
    public List<Message> queryAllByCommodityId(Long CommodityId) {
        return this.messageService.queryAllByCommodityId(CommodityId);
    }

}
