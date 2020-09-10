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
public class RmsDriverGetModelResponse   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("data")
  private RmsDriverSaveModel data = null;

  public RmsDriverGetModelResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * 1:成功
   * @return code
  **/
  @ApiModelProperty(value = "1:成功")

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public RmsDriverGetModelResponse message(String message) {
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

  public RmsDriverGetModelResponse data(RmsDriverSaveModel data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid
  public RmsDriverSaveModel getData() {
    return data;
  }

  public void setData(RmsDriverSaveModel data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverGetModelResponse rmsDriverGetModelResponse = (RmsDriverGetModelResponse) o;
    return Objects.equals(this.code, rmsDriverGetModelResponse.code) &&
        Objects.equals(this.message, rmsDriverGetModelResponse.message) &&
        Objects.equals(this.data, rmsDriverGetModelResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetModelResponse {\n");

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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
