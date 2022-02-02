package com.example.yiyi;

import com.example.yiyi.entity.Message;
import com.example.yiyi.service.CommodityService;
import com.example.yiyi.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YiyiApplicationTests {
    @Resource
    private CommodityService commodityService;
    @Resource
    private MessageService messageService;

    @Test
    void contextLoads() {
        System.out.println(commodityService.queryAllCommodityByLimit(1));
    }

    @Test
    void test() {
        Message message = new Message();
        message.setMessageCommodityId(1L);
        message.setMessageUserId(1L);
        message.setMessageParentId(null);
        message.setMessageContent("111111");
        System.out.println(messageService.insert(message));
    }

}
