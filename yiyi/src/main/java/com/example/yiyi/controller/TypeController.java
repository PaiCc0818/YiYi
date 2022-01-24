package com.example.yiyi.controller;

import com.example.yiyi.entity.Type;
import com.example.yiyi.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类表(Type)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:03
 */
@Controller
@ResponseBody
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 获取所有分类信息
     *
     * @return typeList
     */
    @GetMapping("queryAllType")
    public List<Type> queryAllType() {
        return this.typeService.queryAllType();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryTypeById")
    public Type selectOne(Long id) {
        return this.typeService.queryById(id);
    }

    /**
     * 通过分类名称查询该分类中所有商品信息
     *
     * @param typeName 分类信息
     * @return 该分类信息和分类中所有商品信息
     */
    @GetMapping("queryAllCommodityByTypeName")
    public Type queryAllCommodityByTypeName(String typeName) {
        return typeService.queryAllCommodityByTypeName(typeName);
    }

}
