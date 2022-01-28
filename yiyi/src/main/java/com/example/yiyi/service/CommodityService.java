package com.example.yiyi.service;

import com.example.yiyi.entity.Commodity;

import java.util.List;

/**
 * 商品信息表(Commodity)表服务接口
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:01
 */
public interface CommodityService {

    /**
     * 查询多条数据
     *
     * @param page 查询页数
     * @return 对象列表
     */
    List<Commodity> queryAllCommodityByLimit(int page);

    /**
     * 通过ID查询单条数据
     *
     * @param commodityId 主键
     * @return 实例对象
     */
    Commodity queryCommodityById(Long commodityId);
}
