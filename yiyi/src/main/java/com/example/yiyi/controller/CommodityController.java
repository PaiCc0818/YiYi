package com.example.yiyi.controller;

import com.example.yiyi.entity.Commodity;
import com.example.yiyi.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息表(Commodity)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:00
 */
@Controller
@ResponseBody
@RequestMapping("commodity")
public class CommodityController {
    /**
     * 服务对象
     */
    @Resource
    private CommodityService commodityService;

    /**
     * 分页查询所有商品信息
     * @return 商品信息列表
     */
    @GetMapping("queryAllCommodityByLimit")
    public List<Commodity> queryAllCommodityByLimit(int page){
        return this.commodityService.queryAllCommodityByLimit(page);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryCommodityById")
    public Commodity queryCommodityById(Long id) {
        return this.commodityService.queryCommodityById(id);
    }

    /**
     * 插入商品信息
     * @param commodity 商品实体类
     * @return boolean 是否成功
     */
    @PostMapping("insertCommodity")
    public boolean insertCommodity(Commodity commodity){
        return this.commodityService.insertCommodity(commodity);
    }
    
}
