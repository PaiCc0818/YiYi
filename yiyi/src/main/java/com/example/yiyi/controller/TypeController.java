package com.example.yiyi.controller;

import com.example.yiyi.entity.Type;
import com.example.yiyi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品分类表(Type)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:03
 */
@Controller
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Autowired
    private TypeService typeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Type selectOne(Long id) {
        return this.typeService.queryById(id);
    }

}
