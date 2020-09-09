package com.baomidou.mybatisplus.samples.generator.generate;

import com.baomidou.mybatisplus.samples.generator.generate.model.GenerateCompleteSourceModel;
import com.baomidou.mybatisplus.samples.generator.generate.model.GenerateResourceModel;
import com.baomidou.mybatisplus.samples.generator.utils.IntegerUtil;
import com.baomidou.mybatisplus.samples.generator.utils.PinYinUtil;
import org.springframework.util.StringUtils;

/**
 * 生成权限脚本
 */
public class GenerateResourceSql {
    /**
     * 父级 菜单
     * @param generateResourceModel
     * @return
     */
    public static String generateMenuSql(GenerateResourceModel generateResourceModel){
        return "INSERT INTO `sys_resource` VALUES ("+ generateResourceModel.getMenuId()+",1,1,'" + generateResourceModel.getMenuCode() +
                "','menu','" + generateResourceModel.getMenuName() + "','', 0, 1,'" +
                PinYinUtil.getPinYin(generateResourceModel.getMenuName()) +"',1,1,'admin','admin',"
                + "'2020-02-29 14:34:09', '2020-02-29 14:34:09', ' ', 1, 0);\n";
    }

    /**
     * 一级、二级、、、、、
     * 生成 菜单 新增改 等权限码
     * @param generateResourceModel
     * @return
     */
    public static String generateSql(GenerateResourceModel generateResourceModel){
        String url;
        if(StringUtils.isEmpty(generateResourceModel.getUrl())){
            url = "''";
        }else{
            url = "'"+ generateResourceModel.getUrl() + "'";
        }
        return "INSERT INTO `sys_resource` VALUES ("+ generateResourceModel.getId()+"," +
                generateResourceModel.getParentId()+",1,'" + generateResourceModel.getCode()+ "','"
                + generateResourceModel.getParentCode() + "','" + generateResourceModel.getName() + "',"
                + url + ", 0, 1, '"+ PinYinUtil.getPinYin(generateResourceModel.getName()) +"',1,0,'admin','admin',"
                + "'2020-02-29 14:34:09', '2020-02-29 14:34:09', ' ', 1, 0);\n";
    }

    /**
     * 生成 新增、修改、停用、启用、导入、导出 权限 sql
     * @return
     */
    public static String standard(GenerateResourceModel generateResourceModel){
        return generateStandardSql(generateResourceModel);
    }

    private static String generateStandardSql(GenerateResourceModel generateResourceModel) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < 7; i++) {
            GenerateResourceModel model = new GenerateResourceModel();
            model.setParentId(generateResourceModel.getParentId());
            model.setId(getId(generateResourceModel,i));
            model.setParentCode(generateResourceModel.getTableName());
            model.setName(getName(i,generateResourceModel.getPrefix())[0]);
            model.setCode(generateResourceModel.getParentCode()+"."+
                    getName(i,generateResourceModel.getPrefix())[1]);
            String generateSql = generateSql(model);
            sb.append(generateSql);
        }
        return sb.toString();
    }

    /**
     * 从第几个开始算，默认 0
     * @param generateResourceModel
     * @param i
     * @return
     */
    private static Long getId(GenerateResourceModel generateResourceModel,int i){
        Long aLong = Long.valueOf(generateResourceModel.getParentId() + "0" + i);
        return IntegerUtil.isEmpty(generateResourceModel.getIndex()) ? aLong : aLong + generateResourceModel.getIndex();
    }

    public static String[] getName(int code,String prefix){
        prefix = StringUtils.isEmpty(prefix) ? "" : prefix;
        switch (code){
            case 1:
                return new String[]{prefix+"新增","add"};
            case 2:
                return new String[]{prefix+"修改","edit"};
            case 3:
                return new String[]{prefix+"停用","disable"};
            case 4:
                return new String[]{prefix+"启用","enable"};
            case 5:
                return new String[]{prefix+"导入","import"};
            case 6:
                return new String[]{prefix+"导出","export"};
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        /**
         * 新模块完整配置sql权限：菜单+页面
         */
        GenerateCompleteSourceModel generateCompleteSourceModel = new GenerateCompleteSourceModel();
        String menuCode = "shift";
        String parentCodeName = "driverSchedule";
        generateCompleteSourceModel.setMenuId(106L);
        generateCompleteSourceModel.setMenuCode(menuCode);
        generateCompleteSourceModel.setMenuName("排班管理");
        generateCompleteSourceModel.setParentIdCode("001");
        generateCompleteSourceModel.setParentCodeName(parentCodeName);
        generateCompleteSourceModel.setParentName("司机排班管理");
        generateCompleteSourceModel.setFromIndex(0);
        generateCompleteSourceModel.setTableName(menuCode+"."+parentCodeName);
        completeSourceSql(generateCompleteSourceModel);

        /**
         * 标准 增删改查
         */
        GenerateCompleteSourceModel generateGeneralSourceModel = new GenerateCompleteSourceModel();
        String parentCodeName1 = menuCode+".driverScheduleDetail";
        String tableName = menuCode+"."+parentCodeName;
        generateGeneralSourceModel.setMenuCode(menuCode);
        generateGeneralSourceModel.setTableName(tableName);
        generateGeneralSourceModel.setFromIndex(6);
        generateGeneralSourceModel.setPrefix("司机排班详情-");
        generateStandardSql(generateGeneralSourceModel, 106001L, parentCodeName1);
    }

    /**
     * 生成一个完整模块权限sql，包含菜单、一级、二级
     * @param generateCompleteSourceModel
     */
    private static void completeSourceSql(GenerateCompleteSourceModel generateCompleteSourceModel) {
        /**
         * 配置菜单
         */
        GenerateResourceModel generateMenuModel = new GenerateResourceModel();
        generateMenuModel.setMenuId(generateCompleteSourceModel.getMenuId());
        generateMenuModel.setMenuCode(generateCompleteSourceModel.getMenuCode());
        generateMenuModel.setMenuName(generateCompleteSourceModel.getMenuName());
        String s = generateMenuSql(generateMenuModel);
        System.out.println(s);
        generateGeneralSql(generateCompleteSourceModel);
    }

    /**
     * 已经存在菜单，配置页面的完整权限sql
     * @param generateCompleteSourceModel
     */
    private static void generateGeneralSql(GenerateCompleteSourceModel generateCompleteSourceModel) {
        /**
         * 一级菜单
         */
        Long parentId = Long.valueOf(generateCompleteSourceModel.getMenuId() + generateCompleteSourceModel.getParentIdCode());
        String parentCode = generateCompleteSourceModel.getMenuCode() + "." + generateCompleteSourceModel.getParentCodeName();
        GenerateResourceModel generateResourceModel = new GenerateResourceModel();
        generateResourceModel.setId(parentId);
        generateResourceModel.setParentId(generateCompleteSourceModel.getMenuId());
        generateResourceModel.setCode(parentCode);
        generateResourceModel.setTableName(parentCode);
        generateResourceModel.setParentCode(generateCompleteSourceModel.getMenuCode());
        generateResourceModel.setName(generateCompleteSourceModel.getParentName());
        generateResourceModel.setUrl("/"+generateCompleteSourceModel.getParentCodeName());
        System.out.println(generateSql(generateResourceModel));
        /**
         * 标准增删改查
         */
        generateStandardSql(generateCompleteSourceModel, parentId, parentCode);
    }

    private static void generateStandardSql(GenerateCompleteSourceModel generateCompleteSourceModel, Long parentId, String parentCode) {
        //生成标准权限sql
        GenerateResourceModel standard = new GenerateResourceModel();
        standard.setTableName(generateCompleteSourceModel.getTableName());
        standard.setParentId(parentId);
        standard.setParentCode(parentCode);
        standard.setIndex(generateCompleteSourceModel.getFromIndex());
        standard.setMenuCode(generateCompleteSourceModel.getMenuCode());
        if(StringUtils.isEmpty(standard.getPrefix())){
            standard.setPrefix(generateCompleteSourceModel.getPrefix());
        }
        System.out.println(standard(standard));
    }

}
