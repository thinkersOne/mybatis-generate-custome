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
            entity.setCode(saveModel.getCode());
            entity.setId(saveModel.getId());
            entity.setName(saveModel.getName());
            entity.setPinYin(saveModel.getPinYin());
            entity.setPlanTime(saveModel.getPlanTime());
            entity.setRemark(saveModel.getRemark());
            entity.setRmsProjectId(saveModel.getRmsProjectId());
            entity.setStatus(saveModel.getStatus());
            entity.setPinYin(PinYinUtil.getPinYinHeadChar(saveModel.getName()));
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
            saveModel.setBalanceAmount(entity.getBalanceAmount());
            saveModel.setCardNo(entity.getCardNo());
            saveModel.setCarrierType(entity.getCarrierType());
            saveModel.setDriverId(entity.getDriverId());
            saveModel.setId(entity.getId());
            saveModel.setOilCardType(entity.getOilCardType());
            saveModel.setOilCardTypeName(Enum${table.entityName}Type.getText(entity.getOilCardType()));
            saveModel.setOperationMode(entity.getOperationMode());
            saveModel.setOperationModeName(Enum${table.entityName}OperationMode.getText(entity.getOperationMode()));
            saveModel.setRemark(entity.getRemark());
            saveModel.setRmsMotorcadeId(entity.getRmsMotorcadeId());
            saveModel.setSellerCompanyId(entity.getSellerCompanyId());
            saveModel.setStatus(entity.getStatus());
            saveModel.setStatusName(Enum${table.entityName}Status.getText(entity.getStatus()));
            saveModel.setLossStatus(entity.getLossStatus());
            saveModel.setLossStatusName(Enum${table.entityName}LossStatus.getText(entity.getLossStatus()));
            saveModel.setAllocationStatus(entity.getAllocationStatus());
            saveModel.setAllocationStatusName(Enum${table.entityName}AllocationStatus.getText(entity.getAllocationStatus()));
            saveModel.setVehicleLicense(entity.getVehicleLicense());
            saveModel.setRmsVehicleId(entity.getRmsVehicleId());
            saveModel.setSupplierId(entity.getSupplierId());
            saveModel.setSysOrgId(entity.getSysOrgId());
            saveModel.setRmsProjectId(entity.getRmsProjectId());
            saveModel.setDepositAmount(entity.getDepositAmount());
            response.setData(saveModel);
            return response;
    }
    // 导入
    public <T> ExcelFileInfo<T> getImportMeta() {
            ExcelFileInfo<T> info = new ExcelFileInfo<T>(null);
            info.addExcelColumn("油卡余额", "balanceAmount");

            info.addExcelColumn("卡号", "cardNo");

            info.addExcelColumn("承运商类型 0: 个人 1:公司 2:车队", "carrierType");

            info.addExcelColumn("司机ID", "driverId");

            info.addExcelColumn("id", "id");

            info.addExcelColumn("油卡类型(中石化 中石油)", "oilCardType");

            info.addExcelColumn("营运模式（自营/外请）", "operationMode");

            info.addExcelColumn("备注", "remark");

            info.addExcelColumn("车队id", "rmsMotorcadeId");

            info.addExcelColumn("承运商id", "sellerCompanyId");

            info.addExcelColumn("状态(已下发/可下发/已作废)", "status");

            info.addExcelColumn("供应商id", "supplierId");

            info.addExcelColumn("网点(所属组织id)", "sysOrgId");

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

            model.setBalanceAmount(entity.getBalanceAmount());

            model.setCardNo(entity.getCardNo());

            model.setCarrierType(entity.getCarrierType());
            model.setCarrierTypeName(EnumVmsCarrierType.getText(entity.getCarrierType()));

            model.setCreateTime(entity.getCreateTime());

            model.setCreateUser(entity.getCreateUser());

            model.setDriverId(entity.getDriverId());

            model.setId(entity.getId());

            model.setOilCardType(entity.getOilCardType());
            model.setOilCardTypeName(EnumVmsOilCardType.getText(entity.getOilCardType()));

            model.setOperationMode(entity.getOperationMode());
            model.setOperationModeName(EnumVmsOilCardOperationMode.getText(entity.getOperationMode()));

            model.setRemark(entity.getRemark());

            model.setRmsMotorcadeId(entity.getRmsMotorcadeId());

            model.setSellerCompanyId(entity.getSellerCompanyId());

            model.setStatus(entity.getStatus());
            model.setStatusName(EnumVmsOilCardStatus.getText(entity.getStatus()));

            model.setAllocationStatus(entity.getAllocationStatus());
            model.setAllocationStatusName(EnumVmsOilCardAllocationStatus.getText(entity.getAllocationStatus()));
            model.setLossStatus(entity.getLossStatus());
            model.setLossStatusName(EnumVmsOilCardLossStatus.getText(entity.getLossStatus()));

            model.setVehicleLicense(entity.getVehicleLicense());
            model.setRmsVehicleId(entity.getRmsVehicleId());

            model.setSupplierId(entity.getSupplierId());

            model.setSysOrgId(entity.getSysOrgId());
            model.setRmsProjectId(entity.getRmsProjectId());
            model.setDepositAmount(entity.getDepositAmount());

            model.setTenantId(entity.getTenantId());

            model.setUpdateTime(entity.getUpdateTime());

            model.setUpdateUser(entity.getUpdateUser());

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