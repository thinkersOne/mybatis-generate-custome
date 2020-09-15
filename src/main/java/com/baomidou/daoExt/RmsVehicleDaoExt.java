package com.baomidou.daoExt;

import com.baomidou.entity.RmsVehicleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.samples.generator.generate.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 车辆 DaoExt 接口
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-15
 */
public interface RmsVehicleDaoExt extends BaseDao {
        /**
         * @param queryParam
         * @return
         */
        long getCount(@Param("queryParam") RmsVehicleGetPageParam queryParam);

        /**
         * @param pageParam
         * @param queryParam
         * @return
         */
        List<RmsVehicleEntity> getPage(@Param("pageParam") SqlPageParam pageParam, @Param("queryParam") RmsVehicleGetPageParam queryParam);
       /**
         *
         * @param queryParam
         * @return
         */
        List<RmsVehicleEntity> getByWhere( @Param("queryParam")RmsVehicleGetPageParam queryParam);
}
