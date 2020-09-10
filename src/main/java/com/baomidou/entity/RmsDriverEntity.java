package com.baomidou.entity;

import com.baomidou.mybatisplus.samples.generator.generate.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

public class RmsDriverEntity extends BaseEntity {
    /**
     * 
     * 表 : rms_driver
     * 对应字段 : id
     */
    private Long id;

    /**
     * 所属组织机构
     * 表 : rms_driver
     * 对应字段 : sys_org_id
     */
    private Long sysOrgId;

    /**
     * 车队
     * 表 : rms_driver
     * 对应字段 : rms_motorcade_id
     */
    private Long rmsMotorcadeId;

    /**
     * 名称
     * 表 : rms_driver
     * 对应字段 : name
     */
    private String name;

    /**
     * 编码
     * 表 : rms_driver
     * 对应字段 : code
     */
    private String code;

    /**
     * 电话
     * 表 : rms_driver
     * 对应字段 : iphone
     */
    private String iphone;

    /**
     * 年龄
     * 表 : rms_driver
     * 对应字段 : age
     */
    private Integer age;

    /**
     * 基本工资
     * 表 : rms_driver
     * 对应字段 : base_wages
     */
    private BigDecimal baseWages;

    /**
     * 生日
     * 表 : rms_driver
     * 对应字段 : birthday
     */
    private Date birthday;

    /**
     * 身份证
     * 表 : rms_driver
     * 对应字段 : identity_card
     */
    private String identityCard;

    /**
     * 驾驶证领取时间
     * 表 : rms_driver
     * 对应字段 : license_date
     */
    private Date licenseDate;

    /**
     * 银行账号
     * 表 : rms_driver
     * 对应字段 : bank_account
     */
    private String bankAccount;

    /**
     * 开户行名称
     * 表 : rms_driver
     * 对应字段 : bank_name
     */
    private String bankName;

    /**
     * 电话1
     * 表 : rms_driver
     * 对应字段 : iphone2
     */
    private String iphone2;

    /**
     * 性别 0:女  1:男
     * 表 : rms_driver
     * 对应字段 : sex
     */
    private String sex;

    /**
     * 司机类型 0:自营 1:长期外请 2.临时外请
     * 表 : rms_driver
     * 对应字段 : driver_type
     */
    private Integer driverType;

    /**
     * 任务时长
     * 表 : rms_driver
     * 对应字段 : task_distance
     */
    private BigDecimal taskDistance;

    /**
     * 任务总数
     * 表 : rms_driver
     * 对应字段 : task_count
     */
    private Integer taskCount;

    /**
     * 任务完成数
     * 表 : rms_driver
     * 对应字段 : task_done_count
     */
    private Integer taskDoneCount;

    /**
     * 0:本公司 1：承运商
     * 表 : rms_driver
     * 对应字段 : source_type
     */
    private Integer sourceType;

    /**
     * 状态|1：启用 0：禁用
     * 表 : rms_driver
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 备注
     * 表 : rms_driver
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : rms_driver
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 修改人
     * 表 : rms_driver
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 创建日期
     * 表 : rms_driver
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 修改日期
     * 表 : rms_driver
     * 对应字段 : update_time
     */
    private Date updateTime;

    /**
     * 租户
     * 表 : rms_driver
     * 对应字段 : tenant_id
     */
    private Long tenantId;

    /**
     * 拼音
     * 表 : rms_driver
     * 对应字段 : pin_yin
     */
    private String pinYin;

    /**
     * 1:TMS 2:云调度 3:云驹宝
     * 表 : rms_driver
     * 对应字段 : sys_app_id
     */
    private Long sysAppId;

    /**
     * 最后完成时间
     * 表 : rms_driver
     * 对应字段 : last_complete_time
     */
    private Date lastCompleteTime;

    /**
     * 任务状态  1:执行中 0:空闲中
     * 表 : rms_driver
     * 对应字段 : task_status
     */
    private Integer taskStatus;

    /**
     * 最后完成地点
     * 表 : rms_driver
     * 对应字段 : last_transport_point_name
     */
    private String lastTransportPointName;

    /**
     * 驾驶证号
     * 表 : rms_driver
     * 对应字段 : license_card
     */
    private String licenseCard;

    /**
     * 准驾车型
     * 表 : rms_driver
     * 对应字段 : license_model
     */
    private String licenseModel;

    /**
     * 驾驶证有效期限(截止日期)
     * 表 : rms_driver
     * 对应字段 : license_valid_period
     */
    private Date licenseValidPeriod;

    /**
     * 身份证有效期(截止日期)
     * 表 : rms_driver
     * 对应字段 : identity_valid_period
     */
    private Date identityValidPeriod;

    /**
     * 审核状态 0：未审核 1：已审核
     * 表 : rms_driver
     * 对应字段 : audit_status
     */
    private Integer auditStatus;

    /**
     * get method 
     *
     * @return rms_driver.id：
     */
    public Long getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return rms_driver.sys_org_id：所属组织机构
     */
    public Long getSysOrgId() {
        return sysOrgId;
    }

    /**
     * set method 
     *
     * @param sysOrgId  所属组织机构
     */
    public void setSysOrgId(Long sysOrgId) {
        this.sysOrgId = sysOrgId;
    }

    /**
     * get method 
     *
     * @return rms_driver.rms_motorcade_id：车队
     */
    public Long getRmsMotorcadeId() {
        return rmsMotorcadeId;
    }

    /**
     * set method 
     *
     * @param rmsMotorcadeId  车队
     */
    public void setRmsMotorcadeId(Long rmsMotorcadeId) {
        this.rmsMotorcadeId = rmsMotorcadeId;
    }

    /**
     * get method 
     *
     * @return rms_driver.name：名称
     */
    public String getName() {
        return name;
    }

    /**
     * set method 
     *
     * @param name  名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.code：编码
     */
    public String getCode() {
        return code;
    }

    /**
     * set method 
     *
     * @param code  编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.iphone：电话
     */
    public String getIphone() {
        return iphone;
    }

    /**
     * set method 
     *
     * @param iphone  电话
     */
    public void setIphone(String iphone) {
        this.iphone = iphone == null ? null : iphone.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.age：年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * set method 
     *
     * @param age  年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * get method 
     *
     * @return rms_driver.base_wages：基本工资
     */
    public BigDecimal getBaseWages() {
        return baseWages;
    }

    /**
     * set method 
     *
     * @param baseWages  基本工资
     */
    public void setBaseWages(BigDecimal baseWages) {
        this.baseWages = baseWages;
    }

    /**
     * get method 
     *
     * @return rms_driver.birthday：生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * set method 
     *
     * @param birthday  生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * get method 
     *
     * @return rms_driver.identity_card：身份证
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * set method 
     *
     * @param identityCard  身份证
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.license_date：驾驶证领取时间
     */
    public Date getLicenseDate() {
        return licenseDate;
    }

    /**
     * set method 
     *
     * @param licenseDate  驾驶证领取时间
     */
    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    /**
     * get method 
     *
     * @return rms_driver.bank_account：银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * set method 
     *
     * @param bankAccount  银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.bank_name：开户行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * set method 
     *
     * @param bankName  开户行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.iphone2：电话1
     */
    public String getIphone2() {
        return iphone2;
    }

    /**
     * set method 
     *
     * @param iphone2  电话1
     */
    public void setIphone2(String iphone2) {
        this.iphone2 = iphone2 == null ? null : iphone2.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.sex：性别 0:女  1:男
     */
    public String getSex() {
        return sex;
    }

    /**
     * set method 
     *
     * @param sex  性别 0:女  1:男
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.driver_type：司机类型 0:自营 1:长期外请 2.临时外请
     */
    public Integer getDriverType() {
        return driverType;
    }

    /**
     * set method 
     *
     * @param driverType  司机类型 0:自营 1:长期外请 2.临时外请
     */
    public void setDriverType(Integer driverType) {
        this.driverType = driverType;
    }

    /**
     * get method 
     *
     * @return rms_driver.task_distance：任务时长
     */
    public BigDecimal getTaskDistance() {
        return taskDistance;
    }

    /**
     * set method 
     *
     * @param taskDistance  任务时长
     */
    public void setTaskDistance(BigDecimal taskDistance) {
        this.taskDistance = taskDistance;
    }

    /**
     * get method 
     *
     * @return rms_driver.task_count：任务总数
     */
    public Integer getTaskCount() {
        return taskCount;
    }

    /**
     * set method 
     *
     * @param taskCount  任务总数
     */
    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    /**
     * get method 
     *
     * @return rms_driver.task_done_count：任务完成数
     */
    public Integer getTaskDoneCount() {
        return taskDoneCount;
    }

    /**
     * set method 
     *
     * @param taskDoneCount  任务完成数
     */
    public void setTaskDoneCount(Integer taskDoneCount) {
        this.taskDoneCount = taskDoneCount;
    }

    /**
     * get method 
     *
     * @return rms_driver.source_type：0:本公司 1：承运商
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * set method 
     *
     * @param sourceType  0:本公司 1：承运商
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * get method 
     *
     * @return rms_driver.status：状态|1：启用 0：禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  状态|1：启用 0：禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return rms_driver.remark：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set method 
     *
     * @param remark  备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.create_user：创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * set method 
     *
     * @param createUser  创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.update_user：修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * set method 
     *
     * @param updateUser  修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.create_time：创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set method 
     *
     * @param createTime  创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * get method 
     *
     * @return rms_driver.update_time：修改日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set method 
     *
     * @param updateTime  修改日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * get method 
     *
     * @return rms_driver.tenant_id：租户
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * set method 
     *
     * @param tenantId  租户
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * get method 
     *
     * @return rms_driver.pin_yin：拼音
     */
    public String getPinYin() {
        return pinYin;
    }

    /**
     * set method 
     *
     * @param pinYin  拼音
     */
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.sys_app_id：1:TMS 2:云调度 3:云驹宝
     */
    public Long getSysAppId() {
        return sysAppId;
    }

    /**
     * set method 
     *
     * @param sysAppId  1:TMS 2:云调度 3:云驹宝
     */
    public void setSysAppId(Long sysAppId) {
        this.sysAppId = sysAppId;
    }

    /**
     * get method 
     *
     * @return rms_driver.last_complete_time：最后完成时间
     */
    public Date getLastCompleteTime() {
        return lastCompleteTime;
    }

    /**
     * set method 
     *
     * @param lastCompleteTime  最后完成时间
     */
    public void setLastCompleteTime(Date lastCompleteTime) {
        this.lastCompleteTime = lastCompleteTime;
    }

    /**
     * get method 
     *
     * @return rms_driver.task_status：任务状态  1:执行中 0:空闲中
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * set method 
     *
     * @param taskStatus  任务状态  1:执行中 0:空闲中
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * get method 
     *
     * @return rms_driver.last_transport_point_name：最后完成地点
     */
    public String getLastTransportPointName() {
        return lastTransportPointName;
    }

    /**
     * set method 
     *
     * @param lastTransportPointName  最后完成地点
     */
    public void setLastTransportPointName(String lastTransportPointName) {
        this.lastTransportPointName = lastTransportPointName == null ? null : lastTransportPointName.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.license_card：驾驶证号
     */
    public String getLicenseCard() {
        return licenseCard;
    }

    /**
     * set method 
     *
     * @param licenseCard  驾驶证号
     */
    public void setLicenseCard(String licenseCard) {
        this.licenseCard = licenseCard == null ? null : licenseCard.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.license_model：准驾车型
     */
    public String getLicenseModel() {
        return licenseModel;
    }

    /**
     * set method 
     *
     * @param licenseModel  准驾车型
     */
    public void setLicenseModel(String licenseModel) {
        this.licenseModel = licenseModel == null ? null : licenseModel.trim();
    }

    /**
     * get method 
     *
     * @return rms_driver.license_valid_period：驾驶证有效期限(截止日期)
     */
    public Date getLicenseValidPeriod() {
        return licenseValidPeriod;
    }

    /**
     * set method 
     *
     * @param licenseValidPeriod  驾驶证有效期限(截止日期)
     */
    public void setLicenseValidPeriod(Date licenseValidPeriod) {
        this.licenseValidPeriod = licenseValidPeriod;
    }

    /**
     * get method 
     *
     * @return rms_driver.identity_valid_period：身份证有效期(截止日期)
     */
    public Date getIdentityValidPeriod() {
        return identityValidPeriod;
    }

    /**
     * set method 
     *
     * @param identityValidPeriod  身份证有效期(截止日期)
     */
    public void setIdentityValidPeriod(Date identityValidPeriod) {
        this.identityValidPeriod = identityValidPeriod;
    }

    /**
     * get method 
     *
     * @return rms_driver.audit_status：审核状态 0：未审核 1：已审核
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * set method 
     *
     * @param auditStatus  审核状态 0：未审核 1：已审核
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysOrgId=").append(sysOrgId);
        sb.append(", rmsMotorcadeId=").append(rmsMotorcadeId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", iphone=").append(iphone);
        sb.append(", age=").append(age);
        sb.append(", baseWages=").append(baseWages);
        sb.append(", birthday=").append(birthday);
        sb.append(", identityCard=").append(identityCard);
        sb.append(", licenseDate=").append(licenseDate);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", bankName=").append(bankName);
        sb.append(", iphone2=").append(iphone2);
        sb.append(", sex=").append(sex);
        sb.append(", driverType=").append(driverType);
        sb.append(", taskDistance=").append(taskDistance);
        sb.append(", taskCount=").append(taskCount);
        sb.append(", taskDoneCount=").append(taskDoneCount);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", pinYin=").append(pinYin);
        sb.append(", sysAppId=").append(sysAppId);
        sb.append(", lastCompleteTime=").append(lastCompleteTime);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", lastTransportPointName=").append(lastTransportPointName);
        sb.append(", licenseCard=").append(licenseCard);
        sb.append(", licenseModel=").append(licenseModel);
        sb.append(", licenseValidPeriod=").append(licenseValidPeriod);
        sb.append(", identityValidPeriod=").append(identityValidPeriod);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RmsDriverEntity other = (RmsDriverEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysOrgId() == null ? other.getSysOrgId() == null : this.getSysOrgId().equals(other.getSysOrgId()))
            && (this.getRmsMotorcadeId() == null ? other.getRmsMotorcadeId() == null : this.getRmsMotorcadeId().equals(other.getRmsMotorcadeId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getIphone() == null ? other.getIphone() == null : this.getIphone().equals(other.getIphone()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getBaseWages() == null ? other.getBaseWages() == null : this.getBaseWages().equals(other.getBaseWages()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getIdentityCard() == null ? other.getIdentityCard() == null : this.getIdentityCard().equals(other.getIdentityCard()))
            && (this.getLicenseDate() == null ? other.getLicenseDate() == null : this.getLicenseDate().equals(other.getLicenseDate()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getIphone2() == null ? other.getIphone2() == null : this.getIphone2().equals(other.getIphone2()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getDriverType() == null ? other.getDriverType() == null : this.getDriverType().equals(other.getDriverType()))
            && (this.getTaskDistance() == null ? other.getTaskDistance() == null : this.getTaskDistance().equals(other.getTaskDistance()))
            && (this.getTaskCount() == null ? other.getTaskCount() == null : this.getTaskCount().equals(other.getTaskCount()))
            && (this.getTaskDoneCount() == null ? other.getTaskDoneCount() == null : this.getTaskDoneCount().equals(other.getTaskDoneCount()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getPinYin() == null ? other.getPinYin() == null : this.getPinYin().equals(other.getPinYin()))
            && (this.getSysAppId() == null ? other.getSysAppId() == null : this.getSysAppId().equals(other.getSysAppId()))
            && (this.getLastCompleteTime() == null ? other.getLastCompleteTime() == null : this.getLastCompleteTime().equals(other.getLastCompleteTime()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getLastTransportPointName() == null ? other.getLastTransportPointName() == null : this.getLastTransportPointName().equals(other.getLastTransportPointName()))
            && (this.getLicenseCard() == null ? other.getLicenseCard() == null : this.getLicenseCard().equals(other.getLicenseCard()))
            && (this.getLicenseModel() == null ? other.getLicenseModel() == null : this.getLicenseModel().equals(other.getLicenseModel()))
            && (this.getLicenseValidPeriod() == null ? other.getLicenseValidPeriod() == null : this.getLicenseValidPeriod().equals(other.getLicenseValidPeriod()))
            && (this.getIdentityValidPeriod() == null ? other.getIdentityValidPeriod() == null : this.getIdentityValidPeriod().equals(other.getIdentityValidPeriod()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysOrgId() == null) ? 0 : getSysOrgId().hashCode());
        result = prime * result + ((getRmsMotorcadeId() == null) ? 0 : getRmsMotorcadeId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getIphone() == null) ? 0 : getIphone().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBaseWages() == null) ? 0 : getBaseWages().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getIdentityCard() == null) ? 0 : getIdentityCard().hashCode());
        result = prime * result + ((getLicenseDate() == null) ? 0 : getLicenseDate().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getIphone2() == null) ? 0 : getIphone2().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getDriverType() == null) ? 0 : getDriverType().hashCode());
        result = prime * result + ((getTaskDistance() == null) ? 0 : getTaskDistance().hashCode());
        result = prime * result + ((getTaskCount() == null) ? 0 : getTaskCount().hashCode());
        result = prime * result + ((getTaskDoneCount() == null) ? 0 : getTaskDoneCount().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getPinYin() == null) ? 0 : getPinYin().hashCode());
        result = prime * result + ((getSysAppId() == null) ? 0 : getSysAppId().hashCode());
        result = prime * result + ((getLastCompleteTime() == null) ? 0 : getLastCompleteTime().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getLastTransportPointName() == null) ? 0 : getLastTransportPointName().hashCode());
        result = prime * result + ((getLicenseCard() == null) ? 0 : getLicenseCard().hashCode());
        result = prime * result + ((getLicenseModel() == null) ? 0 : getLicenseModel().hashCode());
        result = prime * result + ((getLicenseValidPeriod() == null) ? 0 : getLicenseValidPeriod().hashCode());
        result = prime * result + ((getIdentityValidPeriod() == null) ? 0 : getIdentityValidPeriod().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        return result;
    }
}