package com.example.yiyi.mapper;

import com.example.yiyi.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<Type> queryAllCommodityByTypeName(String typeName);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param type 实例对象
     * @return 对象列表
     */
    List<Type> queryAll(Type type);

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int insert(Type type);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Type> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Type> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Type> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Type> entities);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Long typeId);

}

