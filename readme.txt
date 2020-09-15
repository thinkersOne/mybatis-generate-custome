1,生成 controller、service、daoExt、mapperExt、swagger、前端html及ts、css文件，直接执行MysqlGenerator 中的main方法，需要注意的是：数据库连接改成自己的
2，生成dao、Entity、Mapper 采用插件方式，执行右侧 maven-》Plugins->mybatis-generator
注：
生成文件采用模板方式，需要事先定义好ftl模板，采用映射方式

优点：
只需要定义一次 模板文件，后期的增删改查等简单的且重复的代码全部可以自动生成，提升效率。

基于mybatis-plus生成。

说明：
1，mybatis-generate 子项目中 MysqlGenerator.java 为主要的启动入口，可生成controller、service、daoExt、mapperExt、swagger、前端html及ts、css文件
2，生成的文件 在父项目mybatis-generate-custome 的src/main/java/com.baomodou 下面
3，mybatis-generate 子项目中 生成dao、Entity、Mapper 采用插件方式，执行右侧 maven-》Plugins->mybatis-generator
4，通过 1 已经生成了 swagger定义 的接口文件后，可在 swagger-generate 子项目中，右侧执行maven-》Plugins->groovy->groovy:execute，
执行完后再执行 swagger-codegen->swagger-codegen:generate 即可生成接口入参、出参及相关接口对象









