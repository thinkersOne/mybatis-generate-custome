package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.samples.generator.utils.StringUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomeConfigBuilder{
    private final CustomeTemplateConfig template;
    private final DataSourceConfig dataSourceConfig;
    private Connection connection;
    /** @deprecated */
    @Deprecated
    private IDbQuery dbQuery;
    /** @deprecated */
    @Deprecated
    private DbType dbType;
    private String superEntityClass;
    private String superMapperClass;
    private String superServiceClass;
    private String superServiceImplClass;
    private String superControllerClass;
    private List<CustomeTableInfo> tableInfoList;
    private Map<String, String> packageInfo;
    private Map<String, String> pathInfo;
    private StrategyConfig strategyConfig;
    private GlobalConfig globalConfig;
    private CustomeInjectionConfig injectionConfig;
    /** @deprecated */
    @Deprecated
    private boolean commentSupported;
    private static final Pattern REGX = Pattern.compile("[~!/@#$%^&*()-_=+\\\\|[{}];:'\",<.>?]+");

    public CustomeConfigBuilder(CustomePackageConfig packageConfig, DataSourceConfig dataSourceConfig,
        StrategyConfig strategyConfig, CustomeTemplateConfig template, GlobalConfig globalConfig) {
        this.globalConfig = Optional.ofNullable(globalConfig).orElseGet(GlobalConfig::new);
        this.template = Optional.ofNullable(template).orElseGet(CustomeTemplateConfig::new);
        if (null == packageConfig) {
            this.handlerPackage(this.template, this.globalConfig.getOutputDir(), new CustomePackageConfig());
        } else {
            this.handlerPackage(this.template, this.globalConfig.getOutputDir(), packageConfig);
        }
        this.dataSourceConfig = dataSourceConfig;
        this.handlerDataSource(dataSourceConfig);
        this.strategyConfig = Optional.ofNullable(strategyConfig).orElseGet(StrategyConfig::new);
        this.commentSupported = !dataSourceConfig.getDbType().equals(DbType.SQLITE);
        this.handlerStrategy(this.strategyConfig);
    }

    public List<CustomeTableInfo> getTableInfoList() {
        return this.tableInfoList;
    }

    public CustomeTemplateConfig getTemplate() {
        return this.template;
    }

    public String getSuperMapperClass() {
        return this.superMapperClass;
    }

    public CustomeInjectionConfig getInjectionConfig() {
        return this.injectionConfig;
    }

    public String getSuperControllerClass() {
        return this.superControllerClass;
    }

    public String getSuperServiceImplClass() {
        return this.superServiceImplClass;
    }

    public String getSuperServiceClass() {
        return this.superServiceClass;
    }

    public Map<String, String> getPackageInfo() {
        return this.packageInfo;
    }

    public String getSuperEntityClass() {
        return this.superEntityClass;
    }

    public CustomeConfigBuilder setTableInfoList(List<CustomeTableInfo> tableInfoList) {
        this.tableInfoList = tableInfoList;
        return this;
    }

    public CustomeConfigBuilder setInjectionConfig(CustomeInjectionConfig injectionConfig) {
        this.injectionConfig = injectionConfig;
        return this;
    }

    private void handlerStrategy(StrategyConfig config) {
        this.processTypes(config);
        this.tableInfoList = this.getTablesInfo(config);
    }

    private static String getValueOrDefault(String value, String defaultValue) {
        return StringUtils.isBlank(value) ? defaultValue : value;
    }

    private void processTypes(StrategyConfig config) {
        this.superServiceClass = getValueOrDefault(config.getSuperServiceClass(), "com.baomidou.mybatisplus.extension.service.IService");
//        this.superServiceImplClass = getValueOrDefault(config.getSuperServiceImplClass(), "com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        this.superMapperClass = getValueOrDefault(config.getSuperMapperClass(), "com.baomidou.mybatisplus.core.mapper.BaseMapper");
        this.superEntityClass = config.getSuperEntityClass();
        this.superControllerClass = config.getSuperControllerClass();
    }

    private List<CustomeTableInfo> getTablesInfo(StrategyConfig config) {
        boolean isInclude = null != config.getInclude() && config.getInclude().length > 0;
        boolean isExclude = null != config.getExclude() && config.getExclude().length > 0;
        if (isInclude && isExclude) {
            throw new RuntimeException("<strategy> 标签中 <include> 与 <exclude> 只能配置一项！");
        } else if (config.getNotLikeTable() != null && config.getLikeTable() != null) {
            throw new RuntimeException("<strategy> 标签中 <likeTable> 与 <notLikeTable> 只能配置一项！");
        } else {
            List<CustomeTableInfo> tableList = new ArrayList();
            List<CustomeTableInfo> includeTableList = new ArrayList();
            List<CustomeTableInfo> excludeTableList = new ArrayList();
            Set<String> notExistTables = new HashSet();
            DbType dbType = this.dataSourceConfig.getDbType();
            IDbQuery dbQuery = this.dataSourceConfig.getDbQuery();

            try {
                String tablesSql = this.dataSourceConfig.getDbQuery().tablesSql();
                String schema;
                if (DbType.POSTGRE_SQL == dbType) {
                    schema = this.dataSourceConfig.getSchemaName();
                    if (schema == null) {
                        schema = "public";
                        this.dataSourceConfig.setSchemaName(schema);
                    }

                    tablesSql = String.format(tablesSql, schema);
                } else if (DbType.KINGBASE_ES == dbType) {
                    schema = this.dataSourceConfig.getSchemaName();
                    if (schema == null) {
                        schema = "PUBLIC";
                        this.dataSourceConfig.setSchemaName(schema);
                    }

                    tablesSql = String.format(tablesSql, schema);
                } else if (DbType.DB2 == dbType) {
                    schema = this.dataSourceConfig.getSchemaName();
                    if (schema == null) {
                        schema = "current schema";
                        this.dataSourceConfig.setSchemaName(schema);
                    }

                    tablesSql = String.format(tablesSql, schema);
                } else if (DbType.ORACLE == dbType) {
                    schema = this.dataSourceConfig.getSchemaName();
                    if (schema == null) {
                        schema = this.dataSourceConfig.getUsername().toUpperCase();
                        this.dataSourceConfig.setSchemaName(schema);
                    }

                    tablesSql = String.format(tablesSql, schema);
                }

                StringBuilder sql = new StringBuilder(tablesSql);
                if (config.isEnableSqlFilter()) {
                    if (config.getLikeTable() != null) {
                        sql.append(" AND ").append(dbQuery.tableName()).append(" LIKE '").append(config.getLikeTable().getValue()).append("'");
                    } else if (config.getNotLikeTable() != null) {
                        sql.append(" AND ").append(dbQuery.tableName()).append(" NOT LIKE '").append(config.getNotLikeTable().getValue()).append("'");
                    }

                    if (isInclude) {
                        sql.append(" AND ").append(dbQuery.tableName()).append(" IN (").append((String)Arrays.stream(config.getInclude()).map((tb) -> {
                            return "'" + tb + "'";
                        }).collect(Collectors.joining(","))).append(")");
                    } else if (isExclude) {
                        sql.append(" AND ").append(dbQuery.tableName()).append(" NOT IN (").append((String)Arrays.stream(config.getExclude()).map((tb) -> {
                            return "'" + tb + "'";
                        }).collect(Collectors.joining(","))).append(")");
                    }
                }

                PreparedStatement preparedStatement = this.connection.prepareStatement(sql.toString());
                Throwable var14 = null;

                try {
                    ResultSet results = preparedStatement.executeQuery();
                    Throwable var16 = null;

                    try {
                        label638:
                        while(true) {
                            while(true) {
                                if (!results.next()) {
                                    break label638;
                                }

                                String tableName = results.getString(dbQuery.tableName());
                                if (StringUtils.isBlank(tableName)) {
                                    System.err.println("当前数据库为空！！！");
                                } else {
                                    CustomeTableInfo tableInfo = new CustomeTableInfo();
                                    tableInfo.setName(tableName);
                                    String commentColumn = dbQuery.tableComment();
                                    if (StringUtils.isNotBlank(commentColumn)) {
                                        String tableComment = results.getString(commentColumn);
                                        if (config.isSkipView() && "VIEW".equals(tableComment)) {
                                            continue;
                                        }

                                        tableInfo.setComment(this.formatComment(tableComment));
                                    }
                                    int var20;
                                    int var21;
                                    String excludeTable;
                                    String[] var54;
                                    if (isInclude) {
                                        var54 = config.getInclude();
                                        var20 = var54.length;

                                        for(var21 = 0; var21 < var20; ++var21) {
                                            excludeTable = var54[var21];
                                            if (this.tableNameMatches(excludeTable, tableName)) {
                                                includeTableList.add(tableInfo);
                                            } else if (!REGX.matcher(excludeTable).find()) {
                                                notExistTables.add(excludeTable);
                                            }
                                        }
                                    } else if (isExclude) {
                                        var54 = config.getExclude();
                                        var20 = var54.length;

                                        for(var21 = 0; var21 < var20; ++var21) {
                                            excludeTable = var54[var21];
                                            if (this.tableNameMatches(excludeTable, tableName)) {
                                                excludeTableList.add(tableInfo);
                                            } else if (!REGX.matcher(excludeTable).find()) {
                                                notExistTables.add(excludeTable);
                                            }
                                        }
                                    }

                                    tableList.add(tableInfo);
                                }
                            }
                        }
                    } catch (Throwable var46) {
                        var16 = var46;
                        throw var46;
                    } finally {
                        if (results != null) {
                            if (var16 != null) {
                                try {
                                    results.close();
                                } catch (Throwable var45) {
                                    var16.addSuppressed(var45);
                                }
                            } else {
                                results.close();
                            }
                        }

                    }
                } catch (Throwable var48) {
                    var14 = var48;
                    throw var48;
                } finally {
                    if (preparedStatement != null) {
                        if (var14 != null) {
                            try {
                                preparedStatement.close();
                            } catch (Throwable var44) {
                                var14.addSuppressed(var44);
                            }
                        } else {
                            preparedStatement.close();
                        }
                    }
                }
                Iterator var51 = tableList.iterator();

                while(var51.hasNext()) {
                    CustomeTableInfo tabInfo = (CustomeTableInfo)var51.next();
                    notExistTables.remove(tabInfo.getName());
                }
                if (notExistTables.size() > 0) {
                    System.err.println("表 " + notExistTables + " 在数据库中不存在！！！");
                }
                if (isExclude) {
                    tableList.removeAll(excludeTableList);
                    includeTableList = tableList;
                }
                if (!isInclude && !isExclude) {
                    includeTableList = tableList;
                }
                includeTableList.forEach((ti) -> {
                    this.convertTableFields(ti, config);
                });
            } catch (SQLException var50) {
                var50.printStackTrace();
            }
            return this.processTable(includeTableList, config);
        }
    }

    public String formatComment(String comment) {
        return StringUtils.isBlank(comment) ? "" : comment.replaceAll("\r\n", "\t");
    }

    private void checkImportPackages(TableInfo tableInfo) {
        if (StringUtils.isNotBlank(this.strategyConfig.getSuperEntityClass())) {
            tableInfo.getImportPackages().add(this.strategyConfig.getSuperEntityClass());
        } else if (this.globalConfig.isActiveRecord()) {
            tableInfo.getImportPackages().add(Model.class.getCanonicalName());
        }

        if (null != this.globalConfig.getIdType() && tableInfo.isHavePrimaryKey()) {
            tableInfo.getImportPackages().add(IdType.class.getCanonicalName());
            tableInfo.getImportPackages().add(TableId.class.getCanonicalName());
        }

        if (StringUtils.isNotBlank(this.strategyConfig.getVersionFieldName()) && CollectionUtils.isNotEmpty(tableInfo.getFields())) {
            tableInfo.getFields().forEach((f) -> {
                if (this.strategyConfig.getVersionFieldName().equals(f.getName())) {
                    tableInfo.getImportPackages().add(Version.class.getCanonicalName());
                }

            });
        }

    }

    private String processName(String name, NamingStrategy strategy, String[] prefix) {
        String propertyName;
        if (ArrayUtils.isNotEmpty(prefix)) {
            if (strategy == NamingStrategy.underline_to_camel) {
                propertyName = NamingStrategy.removePrefixAndCamel(name, prefix);
            } else {
                propertyName = NamingStrategy.removePrefix(name, prefix);
            }
        } else if (strategy == NamingStrategy.underline_to_camel) {
            propertyName = NamingStrategy.underlineToCamel(name);
        } else {
            propertyName = name;
        }

        return propertyName;
    }

    private List<CustomeTableInfo> processTable(List<CustomeTableInfo> tableList, StrategyConfig config) {
        String[] tablePrefix = config.getTablePrefix();

        CustomeTableInfo tableInfo;
        for(Iterator var4 = tableList.iterator(); var4.hasNext(); this.checkImportPackages(tableInfo)) {
            tableInfo = (CustomeTableInfo)var4.next();
            INameConvert nameConvert = this.strategyConfig.getNameConvert();
            String entityName;
            if (null != nameConvert) {
                entityName = nameConvert.entityNameConvert(tableInfo);
            } else {
                entityName = NamingStrategy.capitalFirst(this.processName(tableInfo.getName(), config.getNaming(), tablePrefix));
            }

            if (StringUtils.isNotBlank(this.globalConfig.getEntityName())) {
                tableInfo.setConvert(true);
                tableInfo.setEntityName(String.format(this.globalConfig.getEntityName(), entityName));
            } else {
                tableInfo.setEntityName(this.strategyConfig, entityName);
            }

            if (StringUtils.isNotBlank(this.globalConfig.getMapperName())) {
                tableInfo.setMapperName(String.format(this.globalConfig.getMapperName(), entityName));
            } else {
                tableInfo.setMapperName(entityName + "Mapper");
            }
            // daoExt
            tableInfo.setDaoExtName(entityName + "DaoExt");

//            if (StringUtils.isNotBlank(this.globalConfig.getXmlName())) {
//                tableInfo.setXmlName(String.format(this.globalConfig.getXmlName(), entityName));
//            } else {
//                tableInfo.setXmlName(entityName + "Mapper");
//            }

            if (StringUtils.isNotBlank(this.globalConfig.getXmlName())) {
                tableInfo.setMapperExtName(String.format(this.globalConfig.getXmlName(), entityName));
            } else {
                tableInfo.setMapperExtName(entityName + "MapperExt");
            }

            if (StringUtils.isNotBlank(this.globalConfig.getServiceName())) {
                tableInfo.setServiceName(String.format(this.globalConfig.getServiceName(), entityName));
            } else {
                tableInfo.setServiceName(entityName + "Service");
            }

//            if (StringUtils.isNotBlank(this.globalConfig.getServiceImplName())) {
//                tableInfo.setServiceImplName(String.format(this.globalConfig.getServiceImplName(), entityName));
//            } else {
//                tableInfo.setServiceImplName(entityName + "ServiceImpl");
//            }

            if (StringUtils.isNotBlank(this.globalConfig.getControllerName())) {
                tableInfo.setControllerName(String.format(this.globalConfig.getControllerName(), entityName));
            } else {
                tableInfo.setControllerName(entityName + "Controller");
            }
        }

        return tableList;
    }

    private CustomeTableInfo convertTableFields(CustomeTableInfo tableInfo, StrategyConfig config) {
        boolean haveId = false;
        List<TableField> fieldList = new ArrayList();
        List<TableField> commonFieldList = new ArrayList();
        DbType dbType = this.dataSourceConfig.getDbType();
        IDbQuery dbQuery = this.dataSourceConfig.getDbQuery();
        String tableName = tableInfo.getName();

        try {
            String tableFieldsSql = dbQuery.tableFieldsSql();
            Set<String> h2PkColumns = new HashSet();
            PreparedStatement pkQueryStmt;
            Throwable var12;
            ResultSet results;
            Throwable var14;
            if (DbType.POSTGRE_SQL == dbType) {
                tableFieldsSql = String.format(tableFieldsSql, this.dataSourceConfig.getSchemaName(), tableName);
            } else if (DbType.KINGBASE_ES == dbType) {
                tableFieldsSql = String.format(tableFieldsSql, this.dataSourceConfig.getSchemaName(), tableName);
            } else if (DbType.OSCAR == dbType) {
                tableFieldsSql = String.format(tableFieldsSql, tableName);
            } else if (DbType.DB2 == dbType) {
                tableFieldsSql = String.format(tableFieldsSql, this.dataSourceConfig.getSchemaName(), tableName);
            } else if (DbType.ORACLE == dbType) {
                tableName = tableName.toUpperCase();
                tableFieldsSql = String.format(tableFieldsSql.replace("#schema", this.dataSourceConfig.getSchemaName()), tableName);
            } else if (DbType.DM == dbType) {
                tableName = tableName.toUpperCase();
                tableFieldsSql = String.format(tableFieldsSql, tableName);
            } else if (DbType.H2 == dbType) {
                pkQueryStmt = this.connection.prepareStatement(String.format("select * from INFORMATION_SCHEMA.INDEXES WHERE TABLE_NAME = '%s'", tableName));
                var12 = null;

                try {
                    results = pkQueryStmt.executeQuery();
                    var14 = null;

                    try {
                        while(results.next()) {
                            String primaryKey = results.getString(dbQuery.fieldKey());
                            if (Boolean.parseBoolean(primaryKey)) {
                                h2PkColumns.add(results.getString(dbQuery.fieldName()));
                            }
                        }
                    } catch (Throwable var98) {
                        var14 = var98;
                        throw var98;
                    } finally {
                        if (results != null) {
                            if (var14 != null) {
                                try {
                                    results.close();
                                } catch (Throwable var93) {
                                    var14.addSuppressed(var93);
                                }
                            } else {
                                results.close();
                            }
                        }

                    }
                } catch (Throwable var100) {
                    var12 = var100;
                    throw var100;
                } finally {
                    if (pkQueryStmt != null) {
                        if (var12 != null) {
                            try {
                                pkQueryStmt.close();
                            } catch (Throwable var92) {
                                var12.addSuppressed(var92);
                            }
                        } else {
                            pkQueryStmt.close();
                        }
                    }

                }

                tableFieldsSql = String.format(tableFieldsSql, tableName);
            } else {
                tableFieldsSql = String.format(tableFieldsSql, tableName);
            }

            pkQueryStmt = this.connection.prepareStatement(tableFieldsSql);
            var12 = null;

            try {
                results = pkQueryStmt.executeQuery();
                var14 = null;

                try {
                    while(results.next()) {
                        TableField field = new TableField();
                        String columnName = results.getString(dbQuery.fieldName());
                        boolean isId;
                        if (DbType.H2 == dbType) {
                            isId = h2PkColumns.contains(columnName);
                        } else {
                            String key = results.getString(dbQuery.fieldKey());
                            if (DbType.DB2 != dbType && DbType.SQLITE != dbType) {
                                isId = StringUtils.isNotBlank(key) && "PRI".equals(key.toUpperCase());
                            } else {
                                isId = StringUtils.isNotBlank(key) && "1".equals(key);
                            }
                        }

                        if (isId && !haveId) {
                            haveId = true;
                            field.setKeyFlag(true);
                            tableInfo.setHavePrimaryKey(true);
                            field.setKeyIdentityFlag(dbQuery.isKeyIdentity(results));
                        } else {
                            field.setKeyFlag(false);
                        }

                        String[] fcs = dbQuery.fieldCustom();
                        if (null != fcs) {
                            Map<String, Object> customMap = CollectionUtils.newHashMapWithExpectedSize(fcs.length);
                            String[] var20 = fcs;
                            int var21 = fcs.length;

                            for(int var22 = 0; var22 < var21; ++var22) {
                                String fc = var20[var22];
                                customMap.put(fc, results.getObject(fc));
                            }

                            field.setCustomMap(customMap);
                        }

                        field.setName(columnName);
                        String newColumnName = columnName;
                        IKeyWordsHandler keyWordsHandler = this.dataSourceConfig.getKeyWordsHandler();
                        if (keyWordsHandler != null && keyWordsHandler.isKeyWords(columnName)) {
                            System.err.println(String.format("当前表[%s]存在字段[%s]为数据库关键字或保留字!", tableName, columnName));
                            field.setKeyWords(true);
                            newColumnName = keyWordsHandler.formatColumn(columnName);
                        }

                        field.setColumnName(newColumnName);
                        field.setType(results.getString(dbQuery.fieldType()));
                        INameConvert nameConvert = this.strategyConfig.getNameConvert();
                        if (null != nameConvert) {
                            field.setPropertyName(nameConvert.propertyNameConvert(field));
                        } else {
                            field.setPropertyName(this.strategyConfig, this.processName(field.getName(), config.getColumnNaming()));
                        }
                        field.setColumnType(this.dataSourceConfig.getTypeConvert().processTypeConvert(this.globalConfig, field));
                        String fieldCommentColumn = dbQuery.fieldComment();
                        if (StringUtils.isNotBlank(fieldCommentColumn)) {
                            field.setComment(this.formatComment(results.getString(fieldCommentColumn)));
                        }
                        List<TableFill> tableFillList = this.getStrategyConfig().getTableFillList();
                        if (null != tableFillList) {
                            tableFillList.stream().filter((tf) -> {
                                return tf.getFieldName().equalsIgnoreCase(field.getName());
                            }).findFirst().ifPresent((tf) -> {
                                field.setFill(tf.getFieldFill().name());
                            });
                        }
                        if (this.strategyConfig.includeSuperEntityColumns(field.getName())) {
                            commonFieldList.add(field);
                        } else {
                            fieldList.add(field);
                        }
                    }
                } catch (Throwable var94) {
                    var14 = var94;
                    throw var94;
                } finally {
                    if (results != null) {
                        if (var14 != null) {
                            try {
                                results.close();
                            } catch (Throwable var91) {
                                var14.addSuppressed(var91);
                            }
                        } else {
                            results.close();
                        }
                    }

                }
            } catch (Throwable var96) {
                var12 = var96;
                throw var96;
            } finally {
                if (pkQueryStmt != null) {
                    if (var12 != null) {
                        try {
                            pkQueryStmt.close();
                        } catch (Throwable var90) {
                            var12.addSuppressed(var90);
                        }
                    } else {
                        pkQueryStmt.close();
                    }
                }

            }
        } catch (SQLException var102) {
            System.err.println("SQL Exception：" + var102.getMessage());
        }
        tableInfo.setFields(fieldList);
        tableInfo.setCommonFields(commonFieldList);
        return tableInfo;
    }

    public StrategyConfig getStrategyConfig() {
        return this.strategyConfig;
    }

    private String processName(String name, NamingStrategy strategy) {
        return this.processName(name, strategy, this.strategyConfig.getFieldPrefix());
    }

    private boolean tableNameMatches(String setTableName, String dbTableName) {
        return setTableName.equalsIgnoreCase(dbTableName) || StringUtils.matches(setTableName, dbTableName);
    }

    private void handlerDataSource(DataSourceConfig config) {
        this.connection = config.getConn();
        this.dbType = config.getDbType();
        this.dbQuery = config.getDbQuery();
    }

    private String joinPackage(String parent, String subPackage) {
        return StringUtils.isBlank(parent) ? subPackage : parent + "." + subPackage;
    }

    public Map<String, String> getPathInfo() {
        return this.pathInfo;
    }

    private void handlerPackage(CustomeTemplateConfig template, String outputDir, CustomePackageConfig config) {
        this.packageInfo = CollectionUtils.newHashMapWithExpectedSize(7);
        this.packageInfo.put("ModuleName", config.getModuleName());
        this.packageInfo.put("Entity", this.joinPackage(config.getParent(), config.getEntity()));
        //更改成 MapperExt
        this.packageInfo.put("MapperExt", this.joinPackage(config.getParent(), config.getMapperExt()));
//        this.packageInfo.put("Xml", this.joinPackage(config.getParent(), config.getXml()));
        this.packageInfo.put("Service", this.joinPackage(config.getParent(), config.getService()));
//        this.packageInfo.put("ServiceImpl", this.joinPackage(config.getParent(), config.getServiceImpl()));
        this.packageInfo.put("Controller", this.joinPackage(config.getParent(), config.getController()));
        this.packageInfo.put("DaoExt",this.joinPackage(config.getParent(),config.getDaoExt()));
        // 设置 ftl中的 其他参数
        this.packageInfo.put("limitArgs","#{pageParam.offset},#{pageParam.limit}");
        this.packageInfo.put("pageWhereLike","(`code` like concat(#{queryParam.keyword},'%')\n" +
                "              or `name` like concat(#{queryParam.keyword},'%')\n" +
                "              or `pin_yin` like concat(#{queryParam.keyword},'%')\n" +
                "              )");

        Map<String, String> configPathInfo = config.getPathInfo();
        if (null != configPathInfo) {
            this.pathInfo = configPathInfo;
        } else {
            this.pathInfo = CollectionUtils.newHashMapWithExpectedSize(6);
//            this.setPathInfo(this.pathInfo, template.getEntity(this.getGlobalConfig().isKotlin()), outputDir, "entity_path", "Entity");
//            this.setPathInfo(this.pathInfo, template.getMapper(), outputDir, "mapper_path", "Mapper");
//            this.setPathInfo(this.pathInfo, template.getXml(), outputDir, "xml_path", "Xml");
            this.setPathInfo(this.pathInfo, template.getService(), outputDir, "service_path", "Service");
//            this.setPathInfo(this.pathInfo, template.getServiceImpl(), outputDir, "service_impl_path", "ServiceImpl");
            this.setPathInfo(this.pathInfo, template.getController(), outputDir, "controller_path", "Controller");
            this.setPathInfo(this.pathInfo,template.getDaoExt(),outputDir,"daoExt_path","DaoExt");
            this.setPathInfo(this.pathInfo,template.getMapperExt(),outputDir,"mapperExt_path","MapperExt");
        }
    }

    public GlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    private String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty("java.io.tmpdir");
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir = parentDir + File.separator;
        }
        packageName = packageName.replaceAll("\\.", "\\" + File.separator);
        return parentDir + packageName;
    }

    private void setPathInfo(Map<String, String> pathInfo, String template, String outputDir, String path, String module) {
        if (StringUtils.isNotBlank(template)) {
            pathInfo.put(path, this.joinPath(outputDir, (String)this.packageInfo.get(module)));
        }

    }

}
