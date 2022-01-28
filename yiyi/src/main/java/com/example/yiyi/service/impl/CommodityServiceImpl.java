package com.example.yiyi.service.impl;

import com.example.yiyi.entity.Commodity;
import com.example.yiyi.mapper.CommodityMapper;
import com.example.yiyi.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息表(Commodity)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:01
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    /**
     * 查询多条数据
     *
     * @param page 查询页数
     * @return 对象列表
     */
    @Override
    public List<Commodity> queryAllCommodityByLimit(int page) {
        // 每次请求数据多少
        int limit = 30;
        int offset = page * limit - limit;
        return this.commodityMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param commodityId 主键
     * @return 实例对象
     */
    @Override
    public Commodity queryCommodityById(Long commodityId) {
        return this.commodityMapper.queryById(commodityId);
    }

}
