package com.example.yiyi.service.impl;

import com.example.yiyi.entity.Commodity;
import com.example.yiyi.mapper.CommodityMapper;
import com.example.yiyi.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品信息表(Commodity)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:01
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param commodityId 主键
     * @return 实例对象
     */
    @Override
    public Commodity queryById(Long commodityId) {
        return this.commodityMapper.queryById(commodityId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Commodity> queryAllByLimit(int offset, int limit) {
        return this.commodityMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public Commodity insert(Commodity commodity) {
        this.commodityMapper.insert(commodity);
        return commodity;
    }

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public Commodity update(Commodity commodity) {
        this.commodityMapper.update(commodity);
        return this.queryById(commodity.getCommodityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commodityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long commodityId) {
        return this.commodityMapper.deleteById(commodityId) > 0;
    }
}