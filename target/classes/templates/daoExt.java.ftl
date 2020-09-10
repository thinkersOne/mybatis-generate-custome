package ${package.DaoExt};

import ${package.Entity}.${entity}Entity;
import ${superMapperClassPackage};
import com.baomidou.mybatisplus.samples.generator.generate.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * ${table.comment!} DaoExt 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.daoExtName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.daoExtName} extends BaseDao {
        /**
         * @param queryParam
         * @return
         */
        long getCount(@Param("queryParam") ${entity}GetPageParam queryParam);

        /**
         * @param pageParam
         * @param queryParam
         * @return
         */
        List<${entity}Entity> getPage(@Param("pageParam") SqlPageParam pageParam, @Param("queryParam") ${entity}GetPageParam queryParam);
       /**
         *
         * @param queryParam
         * @return
         */
        List<${entity}Entity> getByWhere( @Param("queryParam")${entity}GetPageParam queryParam);
}
</#if>
