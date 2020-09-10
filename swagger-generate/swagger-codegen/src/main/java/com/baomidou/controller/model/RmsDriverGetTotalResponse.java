package com.baomidou.controller.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * null
 */
@ApiModel(description = "null")
@Validated
public class RmsDriverGetTotalResponse   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("total")
  private Long total = null;

  public RmsDriverGetTotalResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * 1成功  0失败
   * @return code
  **/
  @ApiModelProperty(value = "1成功  0失败")

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public RmsDriverGetTotalResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * return message
   * @return message
  **/
  @ApiModelProperty(value = "return message")

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public RmsDriverGetTotalResponse total(Long total) {
    this.total = total;
    return this;
  }

  /**
   * 总数量
   * @return total
  **/
  @ApiModelProperty(value = "总数量")

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverGetTotalResponse rmsDriverGetTotalResponse = (RmsDriverGetTotalResponse) o;
    return Objects.equals(this.code, rmsDriverGetTotalResponse.code) &&
        Objects.equals(this.message, rmsDriverGetTotalResponse.message) &&
        Objects.equals(this.total, rmsDriverGetTotalResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetTotalResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
