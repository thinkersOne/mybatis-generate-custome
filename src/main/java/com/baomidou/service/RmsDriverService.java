package com.baomidou.service;

import com.baomidou.entity.RmsDriver;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 司机 服务类
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-10
 */
@Service
public class RmsDriverService{
   //列表查询
   public RmsDriverServiceGetPageResponse getPage(RmsDriverServiceGetPageRequest request) {
       RmsDriverServiceGetPageResponse response = new RmsDriverServiceGetPageResponse();
        List<RmsDriverServiceEntity> list = daoExt.getPage(SqlPageParam.create(request.getPageParam()), request.getQueryParam());
       List<RmsDriverServiceGetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
       response.setData(data);
       response.setCode(Response.OK);
       return response;
   }
   //获取总数
   public RmsDriverServiceGetTotalResponse getTotal(@RequestBody RmsDriverServiceGetTotalRequest request) {
       RmsDriverServiceGetTotalResponse response = new RmsDriverServiceGetTotalResponse();
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
       public RmsDriverServiceSaveResponse save(RmsDriverServiceSaveRequest request, AdminSessionInfo sessionInfo) {
           RmsDriverServiceSaveResponse response = this.check(request);
           if (response.getCode() < 1) {
               return response;
           }
           OpLogWriter opLogWriter = this.logService.newOpLogWriter(sessionInfo.getSysUserName());
           RmsDriverServiceEntity entity = null;
           if (request.getModel().getId() != null && request.getModel().getId() > 0) {
           entity = dao.selectByPrimaryKey(request.getModel().getId());
           opLogWriter.setOldEntity(entity);
           }
           entity = loadRmsDriverServiceEntity(request.getModel(),entity, sessionInfo);
           Map<String, Object> mapNew = ToMapUtil.toMap(entity);
           if (entity.getId() == null) {
           //新增
           entity.setId(this.generator.nextId());
           dao.insertSelective(entity);
           opLogWriter.setOperationType(EnumOperationType.RmsDriverServiceAdd);
           } else {
           //更新
           dao.updateByPrimaryKeySelective(entity);
           opLogWriter.setOperationType(EnumOperationType.RmsDriverServiceUpdate);

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
    public RmsDriverServiceEntity loadRmsDriverServiceEntity(RmsDriverServiceSaveModel saveModel,
    RmsDriverServiceEntity entity,AdminSessionInfo sessionInfo){
            if (entity == null) {
                entity = new RmsDriverServiceEntity();
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
    public RmsDriverServiceSaveResponse check(RmsDriverServiceSaveRequest request) {
        RmsDriverServiceSaveResponse response = new RmsDriverServiceSaveResponse();
        EnumRmsDriverServiceErrorCode error = EnumRmsDriverServiceErrorCode.OK;
        if (request == null || request.getModel() == null) {
            error = EnumRmsDriverServiceErrorCode.NOT_NULL;
        }
        RmsDriverServiceSaveModel model = request.getModel();
        response.setCode(error.getCode());
        response.setMessage(error.getMessage());
        return response;
    }
    // 获取详情
    public RmsDriverServiceGetModelResponse getModel(RmsDriverServiceGetModelRequest request) {
            RmsDriverServiceGetModelResponse response = new RmsDriverServiceGetModelResponse();
            RmsDriverServiceEntity entity = dao.selectByPrimaryKey(request.getId());
            RmsDriverServiceSaveModel saveModel = new RmsDriverServiceSaveModel();
            saveModel.setBalanceAmount(entity.getBalanceAmount());
            saveModel.setCardNo(entity.getCardNo());
            saveModel.setCarrierType(entity.getCarrierType());
            saveModel.setDriverId(entity.getDriverId());
            saveModel.setId(entity.getId());
            saveModel.setOilCardType(entity.getOilCardType());
            saveModel.setOilCardTypeName(EnumRmsDriverServiceType.getText(entity.getOilCardType()));
            saveModel.setOperationMode(entity.getOperationMode());
            saveModel.setOperationModeName(EnumRmsDriverServiceOperationMode.getText(entity.getOperationMode()));
            saveModel.setRemark(entity.getRemark());
            saveModel.setRmsMotorcadeId(entity.getRmsMotorcadeId());
            saveModel.setSellerCompanyId(entity.getSellerCompanyId());
            saveModel.setStatus(entity.getStatus());
            saveModel.setStatusName(EnumRmsDriverServiceStatus.getText(entity.getStatus()));
            saveModel.setLossStatus(entity.getLossStatus());
            saveModel.setLossStatusName(EnumRmsDriverServiceLossStatus.getText(entity.getLossStatus()));
            saveModel.setAllocationStatus(entity.getAllocationStatus());
            saveModel.setAllocationStatusName(EnumRmsDriverServiceAllocationStatus.getText(entity.getAllocationStatus()));
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
    public ExcelFileInfo<RmsDriverServiceGetPageModel> getExportMeta(String fileName, List<RmsDriverServiceGetPageModel> dataSource) {
        ExcelFileInfo<RmsDriverServiceGetPageModel> info = getImportMeta();
        info.setDataSource(dataSource);
        info.setFileName(fileName);
        return info;
    }
    // 列表转化
    private RmsDriverServiceGetPageModel toPageModel(RmsDriverServiceEntity entity) {
            RmsDriverServiceetPageModel model = new RmsDriverServiceGetPageModel();

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
    public List<RmsDriverServiceGetPageModel> getExportDataSource(RmsDriverServiceGetPageParam pageParam) {
        List<RmsDriverServiceEntity> list = daoExt.getByWhere(pageParam);
        List<RmsDriverServiceGetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
        setOtherInfo(data);
        return data;
    }

    // 更新状态
    public RmsDriverServiceUpdateStatusResponse updateStatus(RmsDriverServiceUpdateStatusRequest request) {
        RmsDriverServiceUpdateStatusResponse response = new RmsDriverServiceUpdateStatusResponse();
        response.setCode(Response.OK);
        RmsDriverServiceEntity entity = new RmsDriverServiceEntity();
        entity.setStatus(request.getStatus());
        entity.setId(request.getId());
        dao.updateByPrimaryKeySelective(entity);
        return response;
    }



}
