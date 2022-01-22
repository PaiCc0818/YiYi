package com.example.yiyi;

import com.example.yiyi.service.CommodityService;
import com.example.yiyi.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YiyiApplicationTests {
    @Resource
    private CommodityService commodityService;
    @Resource
    private TypeService typeService;

    @Test
    void contextLoads() {
        System.out.println(commodityService.queryAllCommodityByLimit(1));
    }

    @Test
    void test() {
        System.out.println(typeService.queryAllCommodityByTypeName("男装"));
    }

}
