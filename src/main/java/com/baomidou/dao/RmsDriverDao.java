package com.baomidou.dao;

import com.baomidou.entity.RmsDriverEntity;
import com.baomidou.entity.RmsDriverExample;
import com.baomidou.mybatisplus.samples.generator.generate.dao.BaseDao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RmsDriverDao extends BaseDao {
    /**
     * 根据条件计数
     *
     * @param example
     */
    long countByExample(RmsDriverExample example);

    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(RmsDriverEntity record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(RmsDriverEntity record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<RmsDriverEntity> selectByExample(RmsDriverExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    RmsDriverEntity selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RmsDriverEntity record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(RmsDriverEntity record);

    /**
     * 根据条件查询单条数据
     *
     * @param example
     */
    RmsDriverEntity selectOneByExample(RmsDriverExample example);
}