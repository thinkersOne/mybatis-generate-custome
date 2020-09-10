package com.baomidou.controller.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * null
 */
@ApiModel(description = "null")
@Validated
public class RmsDriverGetPageParam   {
  @JsonProperty("keyword")
  private String keyword = null;

  @JsonProperty("iphone")
  private String iphone = null;

  @JsonProperty("iphoneList")
  @Valid
  private List<String> iphoneList = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("auditStatus")
  private String auditStatus = null;

  @JsonProperty("sysOrgId")
  private Long sysOrgId = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("rmsMotorcadeId")
  private Long rmsMotorcadeId = null;

  @JsonProperty("sysOrgIds")
  @Valid
  private List<Long> sysOrgIds = null;

  public RmsDriverGetPageParam keyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  /**
   * 名称 编码
   * @return keyword
  **/
  @ApiModelProperty(value = "名称 编码")

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public RmsDriverGetPageParam iphone(String iphone) {
    this.iphone = iphone;
    return this;
  }

  /**
   * 司机手机号
   * @return iphone
  **/
  @ApiModelProperty(value = "司机手机号")

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public RmsDriverGetPageParam iphoneList(List<String> iphoneList) {
    this.iphoneList = iphoneList;
    return this;
  }

  public RmsDriverGetPageParam addIphoneListItem(String iphoneListItem) {
    if (this.iphoneList == null) {
      this.iphoneList = new ArrayList<>();
    }
    this.iphoneList.add(iphoneListItem);
    return this;
  }

  /**
   * 司机手机号集合
   * @return iphoneList
  **/
  @ApiModelProperty(value = "司机手机号集合")

  public List<String> getIphoneList() {
    return iphoneList;
  }

  public void setIphoneList(List<String> iphoneList) {
    this.iphoneList = iphoneList;
  }

  public RmsDriverGetPageParam status(String status) {
    this.status = status;
    return this;
  }

  /**
   * 状态
   * @return status
  **/
  @ApiModelProperty(value = "状态")

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public RmsDriverGetPageParam auditStatus(String auditStatus) {
    this.auditStatus = auditStatus;
    return this;
  }

  /**
   * 审核状态
   * @return auditStatus
  **/
  @ApiModelProperty(value = "审核状态")

  public String getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(String auditStatus) {
    this.auditStatus = auditStatus;
  }

  public RmsDriverGetPageParam sysOrgId(Long sysOrgId) {
    this.sysOrgId = sysOrgId;
    return this;
  }

  /**
   * null
   * @return sysOrgId
  **/
  @ApiModelProperty(value = "null")

  public Long getSysOrgId() {
    return sysOrgId;
  }

  public void setSysOrgId(Long sysOrgId) {
    this.sysOrgId = sysOrgId;
  }

  public RmsDriverGetPageParam id(Long id) {
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

  public RmsDriverGetPageParam rmsMotorcadeId(Long rmsMotorcadeId) {
    this.rmsMotorcadeId = rmsMotorcadeId;
    return this;
  }

  /**
   * null
   * @return rmsMotorcadeId
  **/
  @ApiModelProperty(value = "null")

  public Long getRmsMotorcadeId() {
    return rmsMotorcadeId;
  }

  public void setRmsMotorcadeId(Long rmsMotorcadeId) {
    this.rmsMotorcadeId = rmsMotorcadeId;
  }

  public RmsDriverGetPageParam sysOrgIds(List<Long> sysOrgIds) {
    this.sysOrgIds = sysOrgIds;
    return this;
  }

  public RmsDriverGetPageParam addSysOrgIdsItem(Long sysOrgIdsItem) {
    if (this.sysOrgIds == null) {
      this.sysOrgIds = new ArrayList<>();
    }
    this.sysOrgIds.add(sysOrgIdsItem);
    return this;
  }

  /**
   * 所属部门
   * @return sysOrgIds
  **/
  @ApiModelProperty(value = "所属部门")

  public List<Long> getSysOrgIds() {
    return sysOrgIds;
  }

  public void setSysOrgIds(List<Long> sysOrgIds) {
    this.sysOrgIds = sysOrgIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverGetPageParam rmsDriverGetPageParam = (RmsDriverGetPageParam) o;
    return Objects.equals(this.keyword, rmsDriverGetPageParam.keyword) &&
        Objects.equals(this.iphone, rmsDriverGetPageParam.iphone) &&
        Objects.equals(this.iphoneList, rmsDriverGetPageParam.iphoneList) &&
        Objects.equals(this.status, rmsDriverGetPageParam.status) &&
        Objects.equals(this.auditStatus, rmsDriverGetPageParam.auditStatus) &&
        Objects.equals(this.sysOrgId, rmsDriverGetPageParam.sysOrgId) &&
        Objects.equals(this.id, rmsDriverGetPageParam.id) &&
        Objects.equals(this.rmsMotorcadeId, rmsDriverGetPageParam.rmsMotorcadeId) &&
        Objects.equals(this.sysOrgIds, rmsDriverGetPageParam.sysOrgIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyword, iphone, iphoneList, status, auditStatus, sysOrgId, id, rmsMotorcadeId, sysOrgIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetPageParam {\n");
    
    sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
    sb.append("    iphone: ").append(toIndentedString(iphone)).append("\n");
    sb.append("    iphoneList: ").append(toIndentedString(iphoneList)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    auditStatus: ").append(toIndentedString(auditStatus)).append("\n");
    sb.append("    sysOrgId: ").append(toIndentedString(sysOrgId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rmsMotorcadeId: ").append(toIndentedString(rmsMotorcadeId)).append("\n");
    sb.append("    sysOrgIds: ").append(toIndentedString(sysOrgIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
