package com.baomidou.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * null
 */
@ApiModel(description = "null")
@Validated
public class RmsDriverGetPageModel   {
  @JsonProperty("age")
  private Integer age = null;

  @JsonProperty("bankAccount")
  private String bankAccount = null;

  @JsonProperty("bankName")
  private String bankName = null;

  @JsonProperty("baseWages")
  private java.math.BigDecimal baseWages = null;

  @JsonProperty("birthday")
  private java.util.Date birthday = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("createTime")
  private java.util.Date createTime = null;

  @JsonProperty("createUser")
  private String createUser = null;

  @JsonProperty("driverType")
  private Integer driverType = null;

  @JsonProperty("driverTypeName")
  private String driverTypeName = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("identityCard")
  private String identityCard = null;

  @JsonProperty("iphone")
  private String iphone = null;

  @JsonProperty("iphone2")
  private String iphone2 = null;

  @JsonProperty("licenseDate")
  private java.util.Date licenseDate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("remark")
  private String remark = null;

  @JsonProperty("rmsMotorcadeId")
  private Long rmsMotorcadeId = null;

  @JsonProperty("rmsMotorcadeName")
  private String rmsMotorcadeName = null;

  @JsonProperty("sex")
  private String sex = null;

  @JsonProperty("sourceType")
  private Integer sourceType = null;

  @JsonProperty("sourceTypeName")
  private String sourceTypeName = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("auditStatus")
  private Integer auditStatus = null;

  @JsonProperty("auditStatusName")
  private String auditStatusName = null;

  @JsonProperty("sysOrgId")
  private Long sysOrgId = null;

  @JsonProperty("sysOrgName")
  private String sysOrgName = null;

  @JsonProperty("taskCount")
  private Integer taskCount = null;

  @JsonProperty("taskDistance")
  private java.math.BigDecimal taskDistance = null;

  @JsonProperty("taskDoneCount")
  private Integer taskDoneCount = null;

  @JsonProperty("tenantId")
  private Long tenantId = null;

  @JsonProperty("updateTime")
  private java.util.Date updateTime = null;

  @JsonProperty("updateUser")
  private String updateUser = null;

  @JsonProperty("pinYin")
  private String pinYin = null;

  @JsonProperty("licenseCard")
  private String licenseCard = null;

  @JsonProperty("licenseModel")
  private String licenseModel = null;

  @JsonProperty("licenseValidPeriod")
  private java.util.Date licenseValidPeriod = null;

  @JsonProperty("identityValidPeriod")
  private java.util.Date identityValidPeriod = null;

  public RmsDriverGetPageModel age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * 年龄
   * @return age
  **/
  @ApiModelProperty(value = "年龄")

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public RmsDriverGetPageModel bankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
    return this;
  }

  /**
   * 银行账号
   * @return bankAccount
  **/
  @ApiModelProperty(value = "银行账号")

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public RmsDriverGetPageModel bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * 开户行名称
   * @return bankName
  **/
  @ApiModelProperty(value = "开户行名称")

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public RmsDriverGetPageModel baseWages(java.math.BigDecimal baseWages) {
    this.baseWages = baseWages;
    return this;
  }

  /**
   * 基本工资
   * @return baseWages
  **/
  @ApiModelProperty(value = "基本工资")

  public java.math.BigDecimal getBaseWages() {
    return baseWages;
  }

  public void setBaseWages(java.math.BigDecimal baseWages) {
    this.baseWages = baseWages;
  }

  public RmsDriverGetPageModel birthday(java.util.Date birthday) {
    this.birthday = birthday;
    return this;
  }

  /**
   * 生日
   * @return birthday
  **/
  @ApiModelProperty(value = "生日")

  @Valid
  public java.util.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.util.Date birthday) {
    this.birthday = birthday;
  }

  public RmsDriverGetPageModel code(String code) {
    this.code = code;
    return this;
  }

  /**
   * 编码
   * @return code
  **/
  @ApiModelProperty(value = "编码")

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public RmsDriverGetPageModel createTime(java.util.Date createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * 创建日期
   * @return createTime
  **/
  @ApiModelProperty(value = "创建日期")

  @Valid
  public java.util.Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.util.Date createTime) {
    this.createTime = createTime;
  }

  public RmsDriverGetPageModel createUser(String createUser) {
    this.createUser = createUser;
    return this;
  }

  /**
   * 创建人
   * @return createUser
  **/
  @ApiModelProperty(value = "创建人")

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public RmsDriverGetPageModel driverType(Integer driverType) {
    this.driverType = driverType;
    return this;
  }

  /**
   * 司机类型 0:自营 1:长期外请 2.临时外请
   * @return driverType
  **/
  @ApiModelProperty(value = "司机类型 0:自营 1:长期外请 2.临时外请")

  public Integer getDriverType() {
    return driverType;
  }

  public void setDriverType(Integer driverType) {
    this.driverType = driverType;
  }

  public RmsDriverGetPageModel driverTypeName(String driverTypeName) {
    this.driverTypeName = driverTypeName;
    return this;
  }

  /**
   * 司机类型
   * @return driverTypeName
  **/
  @ApiModelProperty(value = "司机类型")

  public String getDriverTypeName() {
    return driverTypeName;
  }

  public void setDriverTypeName(String driverTypeName) {
    this.driverTypeName = driverTypeName;
  }

  public RmsDriverGetPageModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * null
   * @return id
  **/
  @ApiModelProperty(value = "null")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RmsDriverGetPageModel identityCard(String identityCard) {
    this.identityCard = identityCard;
    return this;
  }

  /**
   * 身份证
   * @return identityCard
  **/
  @ApiModelProperty(value = "身份证")

  public String getIdentityCard() {
    return identityCard;
  }

  public void setIdentityCard(String identityCard) {
    this.identityCard = identityCard;
  }

  public RmsDriverGetPageModel iphone(String iphone) {
    this.iphone = iphone;
    return this;
  }

  /**
   * 电话
   * @return iphone
  **/
  @ApiModelProperty(value = "电话")

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public RmsDriverGetPageModel iphone2(String iphone2) {
    this.iphone2 = iphone2;
    return this;
  }

  /**
   * 电话1
   * @return iphone2
  **/
  @ApiModelProperty(value = "电话1")

  public String getIphone2() {
    return iphone2;
  }

  public void setIphone2(String iphone2) {
    this.iphone2 = iphone2;
  }

  public RmsDriverGetPageModel licenseDate(java.util.Date licenseDate) {
    this.licenseDate = licenseDate;
    return this;
  }

  /**
   * 驾驶证领取时间
   * @return licenseDate
  **/
  @ApiModelProperty(value = "驾驶证领取时间")

  @Valid
  public java.util.Date getLicenseDate() {
    return licenseDate;
  }

  public void setLicenseDate(java.util.Date licenseDate) {
    this.licenseDate = licenseDate;
  }

  public RmsDriverGetPageModel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 名称
   * @return name
  **/
  @ApiModelProperty(value = "名称")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RmsDriverGetPageModel remark(String remark) {
    this.remark = remark;
    return this;
  }

  /**
   * 备注
   * @return remark
  **/
  @ApiModelProperty(value = "备注")

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public RmsDriverGetPageModel rmsMotorcadeId(Long rmsMotorcadeId) {
    this.rmsMotorcadeId = rmsMotorcadeId;
    return this;
  }

  /**
   * 车队
   * @return rmsMotorcadeId
  **/
  @ApiModelProperty(value = "车队")

  public Long getRmsMotorcadeId() {
    return rmsMotorcadeId;
  }

  public void setRmsMotorcadeId(Long rmsMotorcadeId) {
    this.rmsMotorcadeId = rmsMotorcadeId;
  }

  public RmsDriverGetPageModel rmsMotorcadeName(String rmsMotorcadeName) {
    this.rmsMotorcadeName = rmsMotorcadeName;
    return this;
  }

  /**
   * 车队名称
   * @return rmsMotorcadeName
  **/
  @ApiModelProperty(value = "车队名称")

  public String getRmsMotorcadeName() {
    return rmsMotorcadeName;
  }

  public void setRmsMotorcadeName(String rmsMotorcadeName) {
    this.rmsMotorcadeName = rmsMotorcadeName;
  }

  public RmsDriverGetPageModel sex(String sex) {
    this.sex = sex;
    return this;
  }

  /**
   * 性别 0:女  1:男
   * @return sex
  **/
  @ApiModelProperty(value = "性别 0:女  1:男")

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public RmsDriverGetPageModel sourceType(Integer sourceType) {
    this.sourceType = sourceType;
    return this;
  }

  /**
   * 0:本公司 1：承运商
   * @return sourceType
  **/
  @ApiModelProperty(value = "0:本公司 1：承运商")

  public Integer getSourceType() {
    return sourceType;
  }

  public void setSourceType(Integer sourceType) {
    this.sourceType = sourceType;
  }

  public RmsDriverGetPageModel sourceTypeName(String sourceTypeName) {
    this.sourceTypeName = sourceTypeName;
    return this;
  }

  /**
   * 0:本公司 1：承运商
   * @return sourceTypeName
  **/
  @ApiModelProperty(value = "0:本公司 1：承运商")

  public String getSourceTypeName() {
    return sourceTypeName;
  }

  public void setSourceTypeName(String sourceTypeName) {
    this.sourceTypeName = sourceTypeName;
  }

  public RmsDriverGetPageModel status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 状态
   * @return status
  **/
  @ApiModelProperty(value = "状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public RmsDriverGetPageModel auditStatus(Integer auditStatus) {
    this.auditStatus = auditStatus;
    return this;
  }

  /**
   * 审核状态
   * @return auditStatus
  **/
  @ApiModelProperty(value = "审核状态")

  public Integer getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(Integer auditStatus) {
    this.auditStatus = auditStatus;
  }

  public RmsDriverGetPageModel auditStatusName(String auditStatusName) {
    this.auditStatusName = auditStatusName;
    return this;
  }

  /**
   * 审核状态
   * @return auditStatusName
  **/
  @ApiModelProperty(value = "审核状态")

  public String getAuditStatusName() {
    return auditStatusName;
  }

  public void setAuditStatusName(String auditStatusName) {
    this.auditStatusName = auditStatusName;
  }

  public RmsDriverGetPageModel sysOrgId(Long sysOrgId) {
    this.sysOrgId = sysOrgId;
    return this;
  }

  /**
   * 所属组织机构
   * @return sysOrgId
  **/
  @ApiModelProperty(value = "所属组织机构")

  public Long getSysOrgId() {
    return sysOrgId;
  }

  public void setSysOrgId(Long sysOrgId) {
    this.sysOrgId = sysOrgId;
  }

  public RmsDriverGetPageModel sysOrgName(String sysOrgName) {
    this.sysOrgName = sysOrgName;
    return this;
  }

  /**
   * 组织机构名称
   * @return sysOrgName
  **/
  @ApiModelProperty(value = "组织机构名称")

  public String getSysOrgName() {
    return sysOrgName;
  }

  public void setSysOrgName(String sysOrgName) {
    this.sysOrgName = sysOrgName;
  }

  public RmsDriverGetPageModel taskCount(Integer taskCount) {
    this.taskCount = taskCount;
    return this;
  }

  /**
   * 任务总数
   * @return taskCount
  **/
  @ApiModelProperty(value = "任务总数")

  public Integer getTaskCount() {
    return taskCount;
  }

  public void setTaskCount(Integer taskCount) {
    this.taskCount = taskCount;
  }

  public RmsDriverGetPageModel taskDistance(java.math.BigDecimal taskDistance) {
    this.taskDistance = taskDistance;
    return this;
  }

  /**
   * 任务时长
   * @return taskDistance
  **/
  @ApiModelProperty(value = "任务时长")

  public java.math.BigDecimal getTaskDistance() {
    return taskDistance;
  }

  public void setTaskDistance(java.math.BigDecimal taskDistance) {
    this.taskDistance = taskDistance;
  }

  public RmsDriverGetPageModel taskDoneCount(Integer taskDoneCount) {
    this.taskDoneCount = taskDoneCount;
    return this;
  }

  /**
   * 任务完成数
   * @return taskDoneCount
  **/
  @ApiModelProperty(value = "任务完成数")

  public Integer getTaskDoneCount() {
    return taskDoneCount;
  }

  public void setTaskDoneCount(Integer taskDoneCount) {
    this.taskDoneCount = taskDoneCount;
  }

  public RmsDriverGetPageModel tenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * 租户
   * @return tenantId
  **/
  @ApiModelProperty(value = "租户")

  public Long getTenantId() {
    return tenantId;
  }

  public void setTenantId(Long tenantId) {
    this.tenantId = tenantId;
  }

  public RmsDriverGetPageModel updateTime(java.util.Date updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  /**
   * 修改日期
   * @return updateTime
  **/
  @ApiModelProperty(value = "修改日期")

  @Valid
  public java.util.Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.util.Date updateTime) {
    this.updateTime = updateTime;
  }

  public RmsDriverGetPageModel updateUser(String updateUser) {
    this.updateUser = updateUser;
    return this;
  }

  /**
   * 修改人
   * @return updateUser
  **/
  @ApiModelProperty(value = "修改人")

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public RmsDriverGetPageModel pinYin(String pinYin) {
    this.pinYin = pinYin;
    return this;
  }

  /**
   * 拼音
   * @return pinYin
  **/
  @ApiModelProperty(value = "拼音")

  public String getPinYin() {
    return pinYin;
  }

  public void setPinYin(String pinYin) {
    this.pinYin = pinYin;
  }

  public RmsDriverGetPageModel licenseCard(String licenseCard) {
    this.licenseCard = licenseCard;
    return this;
  }

  /**
   * 驾驶证号
   * @return licenseCard
  **/
  @ApiModelProperty(value = "驾驶证号")

  public String getLicenseCard() {
    return licenseCard;
  }

  public void setLicenseCard(String licenseCard) {
    this.licenseCard = licenseCard;
  }

  public RmsDriverGetPageModel licenseModel(String licenseModel) {
    this.licenseModel = licenseModel;
    return this;
  }

  /**
   * 准驾车型
   * @return licenseModel
  **/
  @ApiModelProperty(value = "准驾车型")

  public String getLicenseModel() {
    return licenseModel;
  }

  public void setLicenseModel(String licenseModel) {
    this.licenseModel = licenseModel;
  }

  public RmsDriverGetPageModel licenseValidPeriod(java.util.Date licenseValidPeriod) {
    this.licenseValidPeriod = licenseValidPeriod;
    return this;
  }

  /**
   * 驾驶证有效期限(截止日期)
   * @return licenseValidPeriod
  **/
  @ApiModelProperty(value = "驾驶证有效期限(截止日期)")

  @Valid
  public java.util.Date getLicenseValidPeriod() {
    return licenseValidPeriod;
  }

  public void setLicenseValidPeriod(java.util.Date licenseValidPeriod) {
    this.licenseValidPeriod = licenseValidPeriod;
  }

  public RmsDriverGetPageModel identityValidPeriod(java.util.Date identityValidPeriod) {
    this.identityValidPeriod = identityValidPeriod;
    return this;
  }

  /**
   * 身份证有效期(截止日期)
   * @return identityValidPeriod
  **/
  @ApiModelProperty(value = "身份证有效期(截止日期)")

  @Valid
  public java.util.Date getIdentityValidPeriod() {
    return identityValidPeriod;
  }

  public void setIdentityValidPeriod(java.util.Date identityValidPeriod) {
    this.identityValidPeriod = identityValidPeriod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverGetPageModel rmsDriverGetPageModel = (RmsDriverGetPageModel) o;
    return Objects.equals(this.age, rmsDriverGetPageModel.age) &&
        Objects.equals(this.bankAccount, rmsDriverGetPageModel.bankAccount) &&
        Objects.equals(this.bankName, rmsDriverGetPageModel.bankName) &&
        Objects.equals(this.baseWages, rmsDriverGetPageModel.baseWages) &&
        Objects.equals(this.birthday, rmsDriverGetPageModel.birthday) &&
        Objects.equals(this.code, rmsDriverGetPageModel.code) &&
        Objects.equals(this.createTime, rmsDriverGetPageModel.createTime) &&
        Objects.equals(this.createUser, rmsDriverGetPageModel.createUser) &&
        Objects.equals(this.driverType, rmsDriverGetPageModel.driverType) &&
        Objects.equals(this.driverTypeName, rmsDriverGetPageModel.driverTypeName) &&
        Objects.equals(this.id, rmsDriverGetPageModel.id) &&
        Objects.equals(this.identityCard, rmsDriverGetPageModel.identityCard) &&
        Objects.equals(this.iphone, rmsDriverGetPageModel.iphone) &&
        Objects.equals(this.iphone2, rmsDriverGetPageModel.iphone2) &&
        Objects.equals(this.licenseDate, rmsDriverGetPageModel.licenseDate) &&
        Objects.equals(this.name, rmsDriverGetPageModel.name) &&
        Objects.equals(this.remark, rmsDriverGetPageModel.remark) &&
        Objects.equals(this.rmsMotorcadeId, rmsDriverGetPageModel.rmsMotorcadeId) &&
        Objects.equals(this.rmsMotorcadeName, rmsDriverGetPageModel.rmsMotorcadeName) &&
        Objects.equals(this.sex, rmsDriverGetPageModel.sex) &&
        Objects.equals(this.sourceType, rmsDriverGetPageModel.sourceType) &&
        Objects.equals(this.sourceTypeName, rmsDriverGetPageModel.sourceTypeName) &&
        Objects.equals(this.status, rmsDriverGetPageModel.status) &&
        Objects.equals(this.auditStatus, rmsDriverGetPageModel.auditStatus) &&
        Objects.equals(this.auditStatusName, rmsDriverGetPageModel.auditStatusName) &&
        Objects.equals(this.sysOrgId, rmsDriverGetPageModel.sysOrgId) &&
        Objects.equals(this.sysOrgName, rmsDriverGetPageModel.sysOrgName) &&
        Objects.equals(this.taskCount, rmsDriverGetPageModel.taskCount) &&
        Objects.equals(this.taskDistance, rmsDriverGetPageModel.taskDistance) &&
        Objects.equals(this.taskDoneCount, rmsDriverGetPageModel.taskDoneCount) &&
        Objects.equals(this.tenantId, rmsDriverGetPageModel.tenantId) &&
        Objects.equals(this.updateTime, rmsDriverGetPageModel.updateTime) &&
        Objects.equals(this.updateUser, rmsDriverGetPageModel.updateUser) &&
        Objects.equals(this.pinYin, rmsDriverGetPageModel.pinYin) &&
        Objects.equals(this.licenseCard, rmsDriverGetPageModel.licenseCard) &&
        Objects.equals(this.licenseModel, rmsDriverGetPageModel.licenseModel) &&
        Objects.equals(this.licenseValidPeriod, rmsDriverGetPageModel.licenseValidPeriod) &&
        Objects.equals(this.identityValidPeriod, rmsDriverGetPageModel.identityValidPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, bankAccount, bankName, baseWages, birthday, code, createTime, createUser, driverType, driverTypeName, id, identityCard, iphone, iphone2, licenseDate, name, remark, rmsMotorcadeId, rmsMotorcadeName, sex, sourceType, sourceTypeName, status, auditStatus, auditStatusName, sysOrgId, sysOrgName, taskCount, taskDistance, taskDoneCount, tenantId, updateTime, updateUser, pinYin, licenseCard, licenseModel, licenseValidPeriod, identityValidPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetPageModel {\n");

    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    baseWages: ").append(toIndentedString(baseWages)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    driverType: ").append(toIndentedString(driverType)).append("\n");
    sb.append("    driverTypeName: ").append(toIndentedString(driverTypeName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    identityCard: ").append(toIndentedString(identityCard)).append("\n");
    sb.append("    iphone: ").append(toIndentedString(iphone)).append("\n");
    sb.append("    iphone2: ").append(toIndentedString(iphone2)).append("\n");
    sb.append("    licenseDate: ").append(toIndentedString(licenseDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
    sb.append("    rmsMotorcadeId: ").append(toIndentedString(rmsMotorcadeId)).append("\n");
    sb.append("    rmsMotorcadeName: ").append(toIndentedString(rmsMotorcadeName)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
    sb.append("    sourceTypeName: ").append(toIndentedString(sourceTypeName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    auditStatus: ").append(toIndentedString(auditStatus)).append("\n");
    sb.append("    auditStatusName: ").append(toIndentedString(auditStatusName)).append("\n");
    sb.append("    sysOrgId: ").append(toIndentedString(sysOrgId)).append("\n");
    sb.append("    sysOrgName: ").append(toIndentedString(sysOrgName)).append("\n");
    sb.append("    taskCount: ").append(toIndentedString(taskCount)).append("\n");
    sb.append("    taskDistance: ").append(toIndentedString(taskDistance)).append("\n");
    sb.append("    taskDoneCount: ").append(toIndentedString(taskDoneCount)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    pinYin: ").append(toIndentedString(pinYin)).append("\n");
    sb.append("    licenseCard: ").append(toIndentedString(licenseCard)).append("\n");
    sb.append("    licenseModel: ").append(toIndentedString(licenseModel)).append("\n");
    sb.append("    licenseValidPeriod: ").append(toIndentedString(licenseValidPeriod)).append("\n");
    sb.append("    identityValidPeriod: ").append(toIndentedString(identityValidPeriod)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
