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
public class RmsDriverUpdateStatusResponse   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  public RmsDriverUpdateStatusResponse code(Integer code) {
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

  public RmsDriverUpdateStatusResponse message(String message) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverUpdateStatusResponse rmsDriverUpdateStatusResponse = (RmsDriverUpdateStatusResponse) o;
    return Objects.equals(this.code, rmsDriverUpdateStatusResponse.code) &&
        Objects.equals(this.message, rmsDriverUpdateStatusResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverUpdateStatusResponse {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
