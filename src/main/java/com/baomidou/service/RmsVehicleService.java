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
 * @since 2020-09-15
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
       entity.setSysOrgId(saveModel.getSysOrgId());
       entity.setLicense(saveModel.getLicense());
       entity.setRmsMotorcadeId(saveModel.getRmsMotorcadeId());
       entity.setTaskStatus(saveModel.getTaskStatus());
       entity.setEnergyType(saveModel.getEnergyType());
       entity.setSourceType(saveModel.getSourceType());
       entity.setAuthStatus(saveModel.getAuthStatus());
       entity.setVehicleTypeId(saveModel.getVehicleTypeId());
       entity.setLength(saveModel.getLength());
       entity.setWidth(saveModel.getWidth());
       entity.setHeight(saveModel.getHeight());
       entity.setRatedLoad(saveModel.getRatedLoad());
       entity.setRatedVolume(saveModel.getRatedVolume());
       entity.setVehicleBrandId(saveModel.getVehicleBrandId());
       entity.setRoadTransportNum(saveModel.getRoadTransportNum());
       entity.setEnduranceMileage(saveModel.getEnduranceMileage());
       entity.setPinYin(saveModel.getPinYin());
       entity.setRemark(saveModel.getRemark());
       entity.setCarriageTypeId(saveModel.getCarriageTypeId());
       entity.setCompanyId(saveModel.getCompanyId());
       entity.setSysAppId(saveModel.getSysAppId());
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
            saveModel.setSysOrgId(entity.getSysOrgId());
            saveModel.setLicense(entity.getLicense());
            saveModel.setRmsMotorcadeId(entity.getRmsMotorcadeId());
            saveModel.setTaskStatus(entity.getTaskStatus());
            saveModel.setEnergyType(entity.getEnergyType());
            saveModel.setSourceType(entity.getSourceType());
            saveModel.setStatus(entity.getStatus());
            saveModel.setAuthStatus(entity.getAuthStatus());
            saveModel.setVehicleTypeId(entity.getVehicleTypeId());
            saveModel.setLength(entity.getLength());
            saveModel.setWidth(entity.getWidth());
            saveModel.setHeight(entity.getHeight());
            saveModel.setRatedLoad(entity.getRatedLoad());
            saveModel.setRatedVolume(entity.getRatedVolume());
            saveModel.setVehicleBrandId(entity.getVehicleBrandId());
            saveModel.setCreateUser(entity.getCreateUser());
            saveModel.setUpdateUser(entity.getUpdateUser());
            saveModel.setCreateTime(entity.getCreateTime());
            saveModel.setUpdateTime(entity.getUpdateTime());
            saveModel.setTenantId(entity.getTenantId());
            saveModel.setRoadTransportNum(entity.getRoadTransportNum());
            saveModel.setEnduranceMileage(entity.getEnduranceMileage());
            saveModel.setPinYin(entity.getPinYin());
            saveModel.setRemark(entity.getRemark());
            saveModel.setCarriageTypeId(entity.getCarriageTypeId());
            saveModel.setCompanyId(entity.getCompanyId());
            saveModel.setSysAppId(entity.getSysAppId());
            response.setData(saveModel);
            return response;
    }
    // 导入
    public <T> ExcelFileInfo<T> getImportMeta() {
            ExcelFileInfo<T> info = new ExcelFileInfo<T>(null);
            info.addExcelColumn("组织机构id", "sysOrgId");
            info.addExcelColumn("车牌号", "license");
            info.addExcelColumn("车队", "rmsMotorcadeId");
            info.addExcelColumn("运输状态", "taskStatus");
            info.addExcelColumn("车辆类型 0:燃油车 1:新能源", "energyType");
            info.addExcelColumn("车辆来源 0:自有车辆 1：社会车辆", "sourceType");
            info.addExcelColumn("状态 0:停用 1:启用", "status");
            info.addExcelColumn("0:未授权 1：已授权", "authStatus");
            info.addExcelColumn("车型", "vehicleTypeId");
            info.addExcelColumn("车长(m)", "length");
            info.addExcelColumn("车宽(m)", "width");
            info.addExcelColumn("车高(m)", "height");
            info.addExcelColumn("载重(kg)", "ratedLoad");
            info.addExcelColumn("体积(m3)", "ratedVolume");
            info.addExcelColumn("车辆品牌(新能源车)", "vehicleBrandId");
            info.addExcelColumn("创建人", "createUser");
            info.addExcelColumn("修改人", "updateUser");
            info.addExcelColumn("创建日期", "createTime");
            info.addExcelColumn("修改日期", "updateTime");
            info.addExcelColumn("租户", "tenantId");
            info.addExcelColumn("道路运输证号", "roadTransportNum");
            info.addExcelColumn("续航里程(新能源车)", "enduranceMileage");
            info.addExcelColumn("拼音", "pinYin");
            info.addExcelColumn("", "remark");
            info.addExcelColumn("车厢类型", "carriageTypeId");
            info.addExcelColumn("所属公司", "companyId");
            info.addExcelColumn("1:TMS 2:云调度 3:云驹宝", "sysAppId");
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
            model.setSysOrgId(entity.getSysOrgId());
            model.setLicense(entity.getLicense());
            model.setRmsMotorcadeId(entity.getRmsMotorcadeId());
            model.setTaskStatus(entity.getTaskStatus());
            model.setEnergyType(entity.getEnergyType());
            model.setSourceType(entity.getSourceType());
            model.setStatus(entity.getStatus());
            model.setAuthStatus(entity.getAuthStatus());
            model.setVehicleTypeId(entity.getVehicleTypeId());
            model.setLength(entity.getLength());
            model.setWidth(entity.getWidth());
            model.setHeight(entity.getHeight());
            model.setRatedLoad(entity.getRatedLoad());
            model.setRatedVolume(entity.getRatedVolume());
            model.setVehicleBrandId(entity.getVehicleBrandId());
            model.setCreateUser(entity.getCreateUser());
            model.setUpdateUser(entity.getUpdateUser());
            model.setCreateTime(entity.getCreateTime());
            model.setUpdateTime(entity.getUpdateTime());
            model.setTenantId(entity.getTenantId());
            model.setRoadTransportNum(entity.getRoadTransportNum());
            model.setEnduranceMileage(entity.getEnduranceMileage());
            model.setPinYin(entity.getPinYin());
            model.setRemark(entity.getRemark());
            model.setCarriageTypeId(entity.getCarriageTypeId());
            model.setCompanyId(entity.getCompanyId());
            model.setSysAppId(entity.getSysAppId());
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
