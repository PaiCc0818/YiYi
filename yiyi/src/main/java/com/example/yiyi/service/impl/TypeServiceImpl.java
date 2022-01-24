package com.example.yiyi.service.impl;

import com.example.yiyi.entity.Type;
import com.example.yiyi.mapper.TypeMapper;
import com.example.yiyi.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类表(Type)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:03
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;

    /**
     * 获取所有分类信息
     *
     * @return typeList
     */
    @Override
    public List<Type> queryAllType() {
        return this.typeMapper.queryAllType();
    }

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
     * @param typeName 分类名称
     * @return 对象列表
     */
    @Override
    public Type queryAllCommodityByTypeName(String typeName) {
        return this.typeMapper.queryAllCommodityByTypeName(typeName);
    }
}
