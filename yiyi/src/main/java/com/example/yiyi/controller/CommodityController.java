package com.example.yiyi.controller;

import com.example.yiyi.entity.Commodity;
import com.example.yiyi.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品信息表(Commodity)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:00
 */
@Controller
@RequestMapping("commodity")
public class CommodityController {
    /**
     * 服务对象
     */
    @Autowired
    private CommodityService commodityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Commodity selectOne(Long id) {
        return this.commodityService.queryById(id);
    }

}
