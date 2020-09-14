package com.baomidou.service;

import com.baomidou.entity.RmsVehicleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆 服务类
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-14
 */
@Service
public class RmsVehicleService{
   //列表查询
   public RmsVehicleGetPageResponse getPage(RmsVehicleGetPageRequest request) {
       RmsVehicleGetPageResponse response = new RmsVehicleGetPageResponse();
        List<RmsVehicleEntity> list = daoExt.getPage(SqlPageParam.create(request.getPageParam()), request.getQueryParam());
       List<RmsVehicleGetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
       response.setData(data);
       response.setCode(Response.OK);
       return response;
   }
   //获取总数
   public RmsVehicleGetTotalResponse getTotal(@RequestBody RmsVehicleGetTotalRequest request) {
       RmsVehicleGetTotalResponse response = new RmsVehicleGetTotalResponse();
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
       public RmsVehicleSaveResponse save(RmsVehicleSaveRequest request, AdminSessionInfo sessionInfo) {
           RmsVehicleSaveResponse response = this.check(request);
           if (response.getCode() < 1) {
               return response;
           }
           OpLogWriter opLogWriter = this.logService.newOpLogWriter(sessionInfo.getSysUserName());
           RmsVehicleEntity entity = null;
           if (request.getModel().getId() != null && request.getModel().getId() > 0) {
           entity = dao.selectByPrimaryKey(request.getModel().getId());
           opLogWriter.setOldEntity(entity);
           }
           entity = loadRmsVehicleEntity(request.getModel(),entity, sessionInfo);
           Map<String, Object> mapNew = ToMapUtil.toMap(entity);
           if (entity.getId() == null) {
           //新增
           entity.setId(this.generator.nextId());
           dao.insertSelective(entity);
           opLogWriter.setOperationType(EnumOperationType.RmsVehicleServiceAdd);
           } else {
           //更新
           dao.updateByPrimaryKeySelective(entity);
           opLogWriter.setOperationType(EnumOperationType.RmsVehicleServiceUpdate);

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
    public RmsVehicleEntity loadRmsVehicleEntity(RmsVehicleSaveModel saveModel,
    RmsVehicleEntity entity,AdminSessionInfo sessionInfo){
            if (entity == null) {
                entity = new RmsVehicleEntity();
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
    public RmsVehicleSaveResponse check(RmsVehicleSaveRequest request) {
        RmsVehicleSaveResponse response = new RmsVehicleSaveResponse();
        EnumRmsVehicleErrorCode error = EnumRmsVehicleErrorCode.OK;
        if (request == null || request.getModel() == null) {
            error = EnumRmsVehicleErrorCode.NOT_NULL;
        }
        RmsVehicleSaveModel model = request.getModel();
        response.setCode(error.getCode());
        response.setMessage(error.getMessage());
        return response;
    }
    // 获取详情
    public RmsVehicleGetModelResponse getModel(RmsVehicleGetModelRequest request) {
            RmsVehicleGetModelResponse response = new RmsVehicleGetModelResponse();
            RmsVehicleEntity entity = dao.selectByPrimaryKey(request.getId());
            RmsVehicleSaveModel saveModel = new RmsVehicleSaveModel();
            saveModel.setBalanceAmount(entity.getBalanceAmount());
            saveModel.setCardNo(entity.getCardNo());
            saveModel.setCarrierType(entity.getCarrierType());
            saveModel.setDriverId(entity.getDriverId());
            saveModel.setId(entity.getId());
            saveModel.setOilCardType(entity.getOilCardType());
            saveModel.setOilCardTypeName(EnumRmsVehicleType.getText(entity.getOilCardType()));
            saveModel.setOperationMode(entity.getOperationMode());
            saveModel.setOperationModeName(EnumRmsVehicleOperationMode.getText(entity.getOperationMode()));
            saveModel.setRemark(entity.getRemark());
            saveModel.setRmsMotorcadeId(entity.getRmsMotorcadeId());
            saveModel.setSellerCompanyId(entity.getSellerCompanyId());
            saveModel.setStatus(entity.getStatus());
            saveModel.setStatusName(EnumRmsVehicleStatus.getText(entity.getStatus()));
            saveModel.setLossStatus(entity.getLossStatus());
            saveModel.setLossStatusName(EnumRmsVehicleLossStatus.getText(entity.getLossStatus()));
            saveModel.setAllocationStatus(entity.getAllocationStatus());
            saveModel.setAllocationStatusName(EnumRmsVehicleAllocationStatus.getText(entity.getAllocationStatus()));
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
    public ExcelFileInfo<RmsVehicleGetPageModel> getExportMeta(String fileName, List<RmsVehicleGetPageModel> dataSource) {
        ExcelFileInfo<RmsVehicleGetPageModel> info = getImportMeta();
        info.setDataSource(dataSource);
        info.setFileName(fileName);
        return info;
    }
    // 列表转化
    private RmsVehicleGetPageModel toPageModel(RmsVehicleEntity entity) {
            RmsVehicleetPageModel model = new RmsVehicleGetPageModel();

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
    public List<RmsVehicleGetPageModel> getExportDataSource(RmsVehicleGetPageParam pageParam) {
        List<RmsVehicleEntity> list = daoExt.getByWhere(pageParam);
        List<RmsVehicleGetPageModel> data = list.stream().map(this::toPageModel).collect(Collectors.toList());
        setOtherInfo(data);
        return data;
    }

    // 更新状态
    public RmsVehicleUpdateStatusResponse updateStatus(RmsVehicleUpdateStatusRequest request) {
        RmsVehicleUpdateStatusResponse response = new RmsVehicleUpdateStatusResponse();
        response.setCode(Response.OK);
        RmsVehicleEntity entity = new RmsVehicleEntity();
        entity.setStatus(request.getStatus());
        entity.setId(request.getId());
        dao.updateByPrimaryKeySelective(entity);
        return response;
    }



}
