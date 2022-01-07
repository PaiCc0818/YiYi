package com.example.yiyi;

import com.example.yiyi.service.CommodityService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YiyiApplicationTests {
    @Resource
    private CommodityService commodityService;

    @Test
    void contextLoads() {
        System.out.println(commodityService.queryAllCommodityByLimit(1));
    }

}
