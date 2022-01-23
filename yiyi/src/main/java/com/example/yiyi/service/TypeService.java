package com.example.yiyi.service;

import com.example.yiyi.entity.Type;

import java.util.List;

/**
 * 商品分类表(Type)表服务接口
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:03
 */
public interface TypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Type queryById(Long typeId);

    /**
     * 查询多条数据
     *
     * @param typeName 分类名称
     * @return 对象列表
     */
    List<Type> queryAllCommodityByTypeName(String typeName);

}
