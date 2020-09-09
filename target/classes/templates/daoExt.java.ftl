package ${package.DaoExt};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

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
public interface ${table.daoExtName} extends ${superMapperClass}<${entity}Entity> {

}
</#if>
