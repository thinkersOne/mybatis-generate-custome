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
public class RmsDriverSaveModel   {
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

  @JsonProperty("driverType")
  private Integer driverType = null;

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

  @JsonProperty("status")
  private Integer status = null;

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

  @JsonProperty("licenseCard")
  private String licenseCard = null;

  @JsonProperty("licenseModel")
  private String licenseModel = null;

  @JsonProperty("licenseValidPeriod")
  private java.util.Date licenseValidPeriod = null;

  @JsonProperty("identityValidPeriod")
  private java.util.Date identityValidPeriod = null;

  @JsonProperty("auditStatus")
  private Integer auditStatus = null;

  @JsonProperty("auditStatusName")
  private String auditStatusName = null;

  public RmsDriverSaveModel age(Integer age) {
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

  public RmsDriverSaveModel bankAccount(String bankAccount) {
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

  public RmsDriverSaveModel bankName(String bankName) {
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

  public RmsDriverSaveModel baseWages(java.math.BigDecimal baseWages) {
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

  public RmsDriverSaveModel birthday(java.util.Date birthday) {
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

  public RmsDriverSaveModel code(String code) {
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

  public RmsDriverSaveModel driverType(Integer driverType) {
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

  public RmsDriverSaveModel id(Long id) {
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

  public RmsDriverSaveModel identityCard(String identityCard) {
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

  public RmsDriverSaveModel iphone(String iphone) {
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

  public RmsDriverSaveModel iphone2(String iphone2) {
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

  public RmsDriverSaveModel licenseDate(java.util.Date licenseDate) {
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

  public RmsDriverSaveModel name(String name) {
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

  public RmsDriverSaveModel remark(String remark) {
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

  public RmsDriverSaveModel rmsMotorcadeId(Long rmsMotorcadeId) {
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

  public RmsDriverSaveModel rmsMotorcadeName(String rmsMotorcadeName) {
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

  public RmsDriverSaveModel sex(String sex) {
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

  public RmsDriverSaveModel sourceType(Integer sourceType) {
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

  public RmsDriverSaveModel status(Integer status) {
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

  public RmsDriverSaveModel sysOrgId(Long sysOrgId) {
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

  public RmsDriverSaveModel sysOrgName(String sysOrgName) {
    this.sysOrgName = sysOrgName;
    return this;
  }

  /**
   * 所属组织名称
   * @return sysOrgName
  **/
  @ApiModelProperty(value = "所属组织名称")

  public String getSysOrgName() {
    return sysOrgName;
  }

  public void setSysOrgName(String sysOrgName) {
    this.sysOrgName = sysOrgName;
  }

  public RmsDriverSaveModel taskCount(Integer taskCount) {
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

  public RmsDriverSaveModel taskDistance(java.math.BigDecimal taskDistance) {
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

  public RmsDriverSaveModel taskDoneCount(Integer taskDoneCount) {
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

  public RmsDriverSaveModel licenseCard(String licenseCard) {
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

  public RmsDriverSaveModel licenseModel(String licenseModel) {
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

  public RmsDriverSaveModel licenseValidPeriod(java.util.Date licenseValidPeriod) {
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

  public RmsDriverSaveModel identityValidPeriod(java.util.Date identityValidPeriod) {
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

  public RmsDriverSaveModel auditStatus(Integer auditStatus) {
    this.auditStatus = auditStatus;
    return this;
  }

  /**
   * 审核状态 0:未审核 1：已审核
   * @return auditStatus
  **/
  @ApiModelProperty(value = "审核状态 0:未审核 1：已审核")

  public Integer getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(Integer auditStatus) {
    this.auditStatus = auditStatus;
  }

  public RmsDriverSaveModel auditStatusName(String auditStatusName) {
    this.auditStatusName = auditStatusName;
    return this;
  }

  /**
   * 审核状态 0:未审核 1：已审核
   * @return auditStatusName
  **/
  @ApiModelProperty(value = "审核状态 0:未审核 1：已审核")

  public String getAuditStatusName() {
    return auditStatusName;
  }

  public void setAuditStatusName(String auditStatusName) {
    this.auditStatusName = auditStatusName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverSaveModel rmsDriverSaveModel = (RmsDriverSaveModel) o;
    return Objects.equals(this.age, rmsDriverSaveModel.age) &&
        Objects.equals(this.bankAccount, rmsDriverSaveModel.bankAccount) &&
        Objects.equals(this.bankName, rmsDriverSaveModel.bankName) &&
        Objects.equals(this.baseWages, rmsDriverSaveModel.baseWages) &&
        Objects.equals(this.birthday, rmsDriverSaveModel.birthday) &&
        Objects.equals(this.code, rmsDriverSaveModel.code) &&
        Objects.equals(this.driverType, rmsDriverSaveModel.driverType) &&
        Objects.equals(this.id, rmsDriverSaveModel.id) &&
        Objects.equals(this.identityCard, rmsDriverSaveModel.identityCard) &&
        Objects.equals(this.iphone, rmsDriverSaveModel.iphone) &&
        Objects.equals(this.iphone2, rmsDriverSaveModel.iphone2) &&
        Objects.equals(this.licenseDate, rmsDriverSaveModel.licenseDate) &&
        Objects.equals(this.name, rmsDriverSaveModel.name) &&
        Objects.equals(this.remark, rmsDriverSaveModel.remark) &&
        Objects.equals(this.rmsMotorcadeId, rmsDriverSaveModel.rmsMotorcadeId) &&
        Objects.equals(this.rmsMotorcadeName, rmsDriverSaveModel.rmsMotorcadeName) &&
        Objects.equals(this.sex, rmsDriverSaveModel.sex) &&
        Objects.equals(this.sourceType, rmsDriverSaveModel.sourceType) &&
        Objects.equals(this.status, rmsDriverSaveModel.status) &&
        Objects.equals(this.sysOrgId, rmsDriverSaveModel.sysOrgId) &&
        Objects.equals(this.sysOrgName, rmsDriverSaveModel.sysOrgName) &&
        Objects.equals(this.taskCount, rmsDriverSaveModel.taskCount) &&
        Objects.equals(this.taskDistance, rmsDriverSaveModel.taskDistance) &&
        Objects.equals(this.taskDoneCount, rmsDriverSaveModel.taskDoneCount) &&
        Objects.equals(this.licenseCard, rmsDriverSaveModel.licenseCard) &&
        Objects.equals(this.licenseModel, rmsDriverSaveModel.licenseModel) &&
        Objects.equals(this.licenseValidPeriod, rmsDriverSaveModel.licenseValidPeriod) &&
        Objects.equals(this.identityValidPeriod, rmsDriverSaveModel.identityValidPeriod) &&
        Objects.equals(this.auditStatus, rmsDriverSaveModel.auditStatus) &&
        Objects.equals(this.auditStatusName, rmsDriverSaveModel.auditStatusName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, bankAccount, bankName, baseWages, birthday, code, driverType, id, identityCard, iphone, iphone2, licenseDate, name, remark, rmsMotorcadeId, rmsMotorcadeName, sex, sourceType, status, sysOrgId, sysOrgName, taskCount, taskDistance, taskDoneCount, licenseCard, licenseModel, licenseValidPeriod, identityValidPeriod, auditStatus, auditStatusName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverSaveModel {\n");

    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    baseWages: ").append(toIndentedString(baseWages)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    driverType: ").append(toIndentedString(driverType)).append("\n");
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
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    sysOrgId: ").append(toIndentedString(sysOrgId)).append("\n");
    sb.append("    sysOrgName: ").append(toIndentedString(sysOrgName)).append("\n");
    sb.append("    taskCount: ").append(toIndentedString(taskCount)).append("\n");
    sb.append("    taskDistance: ").append(toIndentedString(taskDistance)).append("\n");
    sb.append("    taskDoneCount: ").append(toIndentedString(taskDoneCount)).append("\n");
    sb.append("    licenseCard: ").append(toIndentedString(licenseCard)).append("\n");
    sb.append("    licenseModel: ").append(toIndentedString(licenseModel)).append("\n");
    sb.append("    licenseValidPeriod: ").append(toIndentedString(licenseValidPeriod)).append("\n");
    sb.append("    identityValidPeriod: ").append(toIndentedString(identityValidPeriod)).append("\n");
    sb.append("    auditStatus: ").append(toIndentedString(auditStatus)).append("\n");
    sb.append("    auditStatusName: ").append(toIndentedString(auditStatusName)).append("\n");
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
