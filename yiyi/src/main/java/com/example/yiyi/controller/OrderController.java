package com.example.yiyi.controller;

import com.example.yiyi.entity.Order;
import com.example.yiyi.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 订单信息表(Order)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:02
 */
@Controller
@ResponseBody
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 照片上传
     *
     * @return 是否上传成功
     */
    @PostMapping
    public String pictureUpload(String picture) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }
}
