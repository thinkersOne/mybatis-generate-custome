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
public class RmsDriverExistsCodeResponse   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("data")
  private Boolean data = null;

  public RmsDriverExistsCodeResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * 1成功
   * @return code
  **/
  @ApiModelProperty(value = "1成功")

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public RmsDriverExistsCodeResponse message(String message) {
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

  public RmsDriverExistsCodeResponse data(Boolean data) {
    this.data = data;
    return this;
  }

  /**
   * 是否存在
   * @return data
  **/
  @ApiModelProperty(value = "是否存在")

  public Boolean isData() {
    return data;
  }

  public void setData(Boolean data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverExistsCodeResponse rmsDriverExistsCodeResponse = (RmsDriverExistsCodeResponse) o;
    return Objects.equals(this.code, rmsDriverExistsCodeResponse.code) &&
        Objects.equals(this.message, rmsDriverExistsCodeResponse.message) &&
        Objects.equals(this.data, rmsDriverExistsCodeResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverExistsCodeResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
