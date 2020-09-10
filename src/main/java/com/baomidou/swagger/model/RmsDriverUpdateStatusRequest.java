package com.baomidou.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * null
 */
@ApiModel(description = "null")
@Validated
public class RmsDriverUpdateStatusRequest   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("status")
  private Integer status = null;

  public RmsDriverUpdateStatusRequest id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * id
   * @return id
  **/
  @ApiModelProperty(value = "id")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RmsDriverUpdateStatusRequest status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 1:启用 0：停用
   * @return status
  **/
  @ApiModelProperty(value = "1:启用 0：停用")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverUpdateStatusRequest rmsDriverUpdateStatusRequest = (RmsDriverUpdateStatusRequest) o;
    return Objects.equals(this.id, rmsDriverUpdateStatusRequest.id) &&
        Objects.equals(this.status, rmsDriverUpdateStatusRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverUpdateStatusRequest {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
