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
     * @param offset 查询起始位置
     * @param limit  查询条数
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

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    Commodity insert(Commodity commodity);

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    Commodity update(Commodity commodity);

    /**
     * 通过主键删除数据
     *
     * @param commodityId 主键
     * @return 是否成功
     */
    boolean deleteById(Long commodityId);

}
