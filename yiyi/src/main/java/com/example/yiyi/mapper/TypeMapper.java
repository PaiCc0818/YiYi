package com.example.yiyi.mapper;

import com.example.yiyi.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品分类表(Type)表数据库访问层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:03
 */
@Mapper
public interface TypeMapper {
    /**
     * 获取所有分类信息
     *
     * @return typeList
     */
    List<Type> queryAllType();

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Type queryById(Long typeId);

    /**
     * 查询指定行数据
     *
     * @param typeName 分类名称
     * @return 对象列表
     */
    Type queryAllCommodityByTypeName(String typeName);
}

