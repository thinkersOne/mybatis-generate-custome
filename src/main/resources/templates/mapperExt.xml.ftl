<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.MapperExt}.${table.mapperName}">
    <sql id="Page_Where">
        <!--
          @mbggenerated
        -->
        <where>
            <if test="1==1">
                1=1
            </if>
            <if test="queryParam.keyword">
              AND ${package.pageWhereLike}
            </if>
        </where>
    </sql>

    <select id="getPage" resultType="${package.Entity}.${table.entityName}Entity">
        select
        ${table.name}.*
        from ${table.name}
        inner join (select ${table.name}.* from ${table.name}
        <if test="queryParam!= null">
            <include refid="Page_Where" />
        </if>
        order by ${table.name}.id desc limit ${package.limitArgs} ) as a on a.id=${table.name}.id
        order by  ${table.name}.id desc
    </select>
    <select id="getCount" resultType="long">
        select count(*) from ${table.name}
        <if test="queryParam!= null">
            <include refid="Page_Where" />
        </if>
    </select>
    <select id="getByWhere" resultType="${package.Entity}.${table.entityName}">
            select * from ${table.name}
                <include refid="Page_Where" />
    </select>

</mapper>
