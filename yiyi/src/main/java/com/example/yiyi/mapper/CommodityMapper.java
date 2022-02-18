package com.example.yiyi.mapper;

import com.example.yiyi.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品信息表(Commodity)表数据库访问层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:01
 */
@Mapper
public interface CommodityMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param commodityId 主键
     * @return 实例对象
     */
    Commodity queryById(Long commodityId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Commodity> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 插入商品信息
     * @param commodity 商品实体类
     * @return boolean 是否成功
     */
    boolean insertCommodity(Commodity commodity);
}

