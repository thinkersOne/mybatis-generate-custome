package ${package.Service};

import ${package.Entity}.${entity}Entity;
import ${superServiceClassPackage};
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
class ${table.serviceName}
<#else>
@Service
public class ${table.serviceName}{
   //列表查询
   public ${table.entityName}GetPageResponse getPage(${table.entityName}GetPageRequest request) {
       ${table.entityName}GetPageResponse response = new ${table.entityName}GetPageResponse();
        List<${table.entityName}Entity> list = daoExt.getPage(SqlPageParam.create(request.getPageParam()), request.getQueryParam());
       List<${table.entityName}GetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
       response.setData(data);
       response.setCode(Response.OK);
       return response;
   }
   //获取总数
   public ${table.entityName}GetTotalResponse getTotal(@RequestBody ${table.entityName}GetTotalRequest request) {
       ${table.entityName}GetTotalResponse response = new ${table.entityName}GetTotalResponse();
       long total = daoExt.getCount(request.getQueryParam());
       response.setTotal(total);
       response.setCode(Response.OK);
       return response;
   }

    /**
        * 保存
        *
        * @param request
        * @return
        */
       public ${table.entityName}SaveResponse save(${table.entityName}SaveRequest request, AdminSessionInfo sessionInfo) {
           ${table.entityName}SaveResponse response = this.check(request);
           if (response.getCode() < 1) {
               return response;
           }
           OpLogWriter opLogWriter = this.logService.newOpLogWriter(sessionInfo.getSysUserName());
           ${table.entityName}Entity entity = null;
           if (request.getModel().getId() != null && request.getModel().getId() > 0) {
           entity = dao.selectByPrimaryKey(request.getModel().getId());
           opLogWriter.setOldEntity(entity);
           }
           entity = load${table.entityName}Entity(request.getModel(),entity, sessionInfo);
           Map<String, Object> mapNew = ToMapUtil.toMap(entity);
           if (entity.getId() == null) {
           //新增
           entity.setId(this.generator.nextId());
           dao.insertSelective(entity);
           opLogWriter.setOperationType(EnumOperationType.${table.serviceName}Add);
           } else {
           //更新
           dao.updateByPrimaryKeySelective(entity);
           opLogWriter.setOperationType(EnumOperationType.${table.serviceName}Update);

           }
           opLogWriter.setNewEntity(entity)
           .commit();
           response.setCode(Response.OK);
           response.setData(entity.getId());
           return response;
       }
    /**
    * 保存
    */
    public ${table.entityName}Entity load${table.entityName}Entity(${table.entityName}SaveModel saveModel,
    ${table.entityName}Entity entity,AdminSessionInfo sessionInfo){
       if (entity == null) {
           entity = new ${table.entityName}Entity();
           entity.setTenantId(sessionInfo.getCurrentTenantId());
           entity.setCreateUser(sessionInfo.getSysUserName());
           entity.setCreateTime(new Date());
           entity.setStatus(1);
       }
     <#list table.fields as f>
       <#if f.name != 'tenant_id' && f.name != 'create_user' && f.name != 'create_time' && f.name != 'status'
       && f.name != 'update_user' && f.name != 'update_time'>
       entity.set${f.propertyName ? cap_first}(saveModel.get${f.propertyName ? cap_first}());
       </#if>
     </#list>
       entity.setUpdateUser(sessionInfo.getSysUserName());
       entity.setUpdateTime(new Date());
       return  entity;
    }
    // check
    public ${table.entityName}SaveResponse check(${table.entityName}SaveRequest request) {
        ${table.entityName}SaveResponse response = new ${table.entityName}SaveResponse();
        Enum${table.entityName}ErrorCode error = Enum${table.entityName}ErrorCode.OK;
        if (request == null || request.getModel() == null) {
            error = Enum${table.entityName}ErrorCode.NOT_NULL;
        }
        ${table.entityName}SaveModel model = request.getModel();
        response.setCode(error.getCode());
        response.setMessage(error.getMessage());
        return response;
    }
    // 获取详情
    public ${table.entityName}GetModelResponse getModel(${table.entityName}GetModelRequest request) {
            ${table.entityName}GetModelResponse response = new ${table.entityName}GetModelResponse();
            ${table.entityName}Entity entity = dao.selectByPrimaryKey(request.getId());
            ${table.entityName}SaveModel saveModel = new ${table.entityName}SaveModel();
          <#list table.fields as f>
            saveModel.set${f.propertyName ? cap_first}(entity.get${f.propertyName ? cap_first}());
          </#list>
            response.setData(saveModel);
            return response;
    }
    // 导入
    public <T> ExcelFileInfo<T> getImportMeta() {
            ExcelFileInfo<T> info = new ExcelFileInfo<T>(null);
          <#list table.fields as f>
            info.addExcelColumn("${f.comment}", "${f.propertyName}");
          </#list>
            return info;
    }
    // 导出
    public ExcelFileInfo<${table.entityName}GetPageModel> getExportMeta(String fileName, List<${table.entityName}GetPageModel> dataSource) {
        ExcelFileInfo<${table.entityName}GetPageModel> info = getImportMeta();
        info.setDataSource(dataSource);
        info.setFileName(fileName);
        return info;
    }
    // 列表转化
    private ${table.entityName}GetPageModel toPageModel(${table.entityName}Entity entity) {
            ${table.entityName}etPageModel model = new ${table.entityName}GetPageModel();
          <#list table.fields as f>
            model.set${f.propertyName ? cap_first}(entity.get${f.propertyName ? cap_first}());
          </#list>
            return model;
     }
    // 获取导出数据
    public List<${table.entityName}GetPageModel> getExportDataSource(${table.entityName}GetPageParam pageParam) {
        List<${table.entityName}Entity> list = daoExt.getByWhere(pageParam);
        List<${table.entityName}GetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
        setOtherInfo(data);
        return data;
    }

    // 更新状态
    public ${table.entityName}UpdateStatusResponse updateStatus(${table.entityName}UpdateStatusRequest request) {
        ${table.entityName}UpdateStatusResponse response = new ${table.entityName}UpdateStatusResponse();
        response.setCode(Response.OK);
        ${table.entityName}Entity entity = new ${table.entityName}Entity();
        entity.setStatus(request.getStatus());
        entity.setId(request.getId());
        dao.updateByPrimaryKeySelective(entity);
        return response;
    }



}
</#if>