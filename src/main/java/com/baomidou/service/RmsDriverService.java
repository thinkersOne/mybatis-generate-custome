package com.baomidou.service;

import com.baomidou.entity.RmsDriverEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 司机 服务类
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-11
 */
@Service
public class RmsDriverService{
   //列表查询
   public RmsDriverGetPageResponse getPage(RmsDriverGetPageRequest request) {
       RmsDriverGetPageResponse response = new RmsDriverGetPageResponse();
        List<RmsDriverEntity> list = daoExt.getPage(SqlPageParam.create(request.getPageParam()), request.getQueryParam());
       List<RmsDriverGetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
       response.setData(data);
       response.setCode(Response.OK);
       return response;
   }
   //获取总数
   public RmsDriverGetTotalResponse getTotal(@RequestBody RmsDriverGetTotalRequest request) {
       RmsDriverGetTotalResponse response = new RmsDriverGetTotalResponse();
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
       public RmsDriverSaveResponse save(RmsDriverSaveRequest request, AdminSessionInfo sessionInfo) {
           RmsDriverSaveResponse response = this.check(request);
           if (response.getCode() < 1) {
               return response;
           }
           OpLogWriter opLogWriter = this.logService.newOpLogWriter(sessionInfo.getSysUserName());
           RmsDriverEntity entity = null;
           if (request.getModel().getId() != null && request.getModel().getId() > 0) {
           entity = dao.selectByPrimaryKey(request.getModel().getId());
           opLogWriter.setOldEntity(entity);
           }
           entity = loadRmsDriverEntity(request.getModel(),entity, sessionInfo);
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
    public RmsDriverEntity loadRmsDriverEntity(RmsDriverSaveModel saveModel,
    RmsDriverEntity entity,AdminSessionInfo sessionInfo){
            if (entity == null) {
                entity = new RmsDriverEntity();
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
    public RmsDriverSaveResponse check(RmsDriverSaveRequest request) {
        RmsDriverSaveResponse response = new RmsDriverSaveResponse();
        EnumRmsDriverErrorCode error = EnumRmsDriverErrorCode.OK;
        if (request == null || request.getModel() == null) {
            error = EnumRmsDriverErrorCode.NOT_NULL;
        }
        RmsDriverSaveModel model = request.getModel();
        response.setCode(error.getCode());
        response.setMessage(error.getMessage());
        return response;
    }
    // 获取详情
    public RmsDriverGetModelResponse getModel(RmsDriverGetModelRequest request) {
            RmsDriverGetModelResponse response = new RmsDriverGetModelResponse();
            RmsDriverEntity entity = dao.selectByPrimaryKey(request.getId());
            RmsDriverSaveModel saveModel = new RmsDriverSaveModel();
            saveModel.setBalanceAmount(entity.getBalanceAmount());
            saveModel.setCardNo(entity.getCardNo());
            saveModel.setCarrierType(entity.getCarrierType());
            saveModel.setDriverId(entity.getDriverId());
            saveModel.setId(entity.getId());
            saveModel.setOilCardType(entity.getOilCardType());
            saveModel.setOilCardTypeName(EnumRmsDriverType.getText(entity.getOilCardType()));
            saveModel.setOperationMode(entity.getOperationMode());
            saveModel.setOperationModeName(EnumRmsDriverOperationMode.getText(entity.getOperationMode()));
            saveModel.setRemark(entity.getRemark());
            saveModel.setRmsMotorcadeId(entity.getRmsMotorcadeId());
            saveModel.setSellerCompanyId(entity.getSellerCompanyId());
            saveModel.setStatus(entity.getStatus());
            saveModel.setStatusName(EnumRmsDriverStatus.getText(entity.getStatus()));
            saveModel.setLossStatus(entity.getLossStatus());
            saveModel.setLossStatusName(EnumRmsDriverLossStatus.getText(entity.getLossStatus()));
            saveModel.setAllocationStatus(entity.getAllocationStatus());
            saveModel.setAllocationStatusName(EnumRmsDriverAllocationStatus.getText(entity.getAllocationStatus()));
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
    public ExcelFileInfo<RmsDriverGetPageModel> getExportMeta(String fileName, List<RmsDriverGetPageModel> dataSource) {
        ExcelFileInfo<RmsDriverGetPageModel> info = getImportMeta();
        info.setDataSource(dataSource);
        info.setFileName(fileName);
        return info;
    }
    // 列表转化
    private RmsDriverGetPageModel toPageModel(RmsDriverEntity entity) {
            RmsDriveretPageModel model = new RmsDriverGetPageModel();

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
    public List<RmsDriverGetPageModel> getExportDataSource(RmsDriverGetPageParam pageParam) {
        List<RmsDriverEntity> list = daoExt.getByWhere(pageParam);
        List<RmsDriverGetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
        setOtherInfo(data);
        return data;
    }

    // 更新状态
    public RmsDriverUpdateStatusResponse updateStatus(RmsDriverUpdateStatusRequest request) {
        RmsDriverUpdateStatusResponse response = new RmsDriverUpdateStatusResponse();
        response.setCode(Response.OK);
        RmsDriverEntity entity = new RmsDriverEntity();
        entity.setStatus(request.getStatus());
        entity.setId(request.getId());
        dao.updateByPrimaryKeySelective(entity);
        return response;
    }



}
