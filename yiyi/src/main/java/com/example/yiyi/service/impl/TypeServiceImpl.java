package com.example.yiyi.service.impl;

import com.example.yiyi.entity.Type;
import com.example.yiyi.mapper.TypeMapper;
import com.example.yiyi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类表(Type)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:03
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public Type queryById(Long typeId) {
        return this.typeMapper.queryById(typeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Type> queryAllByLimit(int offset, int limit) {
        return this.typeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type insert(Type type) {
        this.typeMapper.insert(type);
        return type;
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type update(Type type) {
        this.typeMapper.update(type);
        return this.queryById(type.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long typeId) {
        return this.typeMapper.deleteById(typeId) > 0;
    }
}