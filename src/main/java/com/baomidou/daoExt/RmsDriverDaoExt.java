package com.baomidou.daoExt;

import com.baomidou.entity.RmsDriverEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.samples.generator.generate.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 司机 DaoExt 接口
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-11
 */
public interface RmsDriverDaoExt extends BaseDao {
        /**
         * @param queryParam
         * @return
         */
        long getCount(@Param("queryParam") RmsDriverGetPageParam queryParam);

        /**
         * @param pageParam
         * @param queryParam
         * @return
         */
        List<RmsDriverEntity> getPage(@Param("pageParam") SqlPageParam pageParam, @Param("queryParam") RmsDriverGetPageParam queryParam);
       /**
         *
         * @param queryParam
         * @return
         */
        List<RmsDriverEntity> getByWhere( @Param("queryParam")RmsDriverGetPageParam queryParam);
}
