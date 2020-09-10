package com.baomidou.controller.model;

import java.util.Objects;
import com.baomidou.controller.model.RmsDriverGetPageModel;
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
public class RmsDriverGetPageResponse   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("data")
  @Valid
  private List<RmsDriverGetPageModel> data = null;

  public RmsDriverGetPageResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * 1成功  -1失败
   * @return code
  **/
  @ApiModelProperty(value = "1成功  -1失败")

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public RmsDriverGetPageResponse message(String message) {
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

  public RmsDriverGetPageResponse data(List<RmsDriverGetPageModel> data) {
    this.data = data;
    return this;
  }

  public RmsDriverGetPageResponse addDataItem(RmsDriverGetPageModel dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * 信息
   * @return data
  **/
  @ApiModelProperty(value = "信息")
  @Valid
  public List<RmsDriverGetPageModel> getData() {
    return data;
  }

  public void setData(List<RmsDriverGetPageModel> data) {
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
    RmsDriverGetPageResponse rmsDriverGetPageResponse = (RmsDriverGetPageResponse) o;
    return Objects.equals(this.code, rmsDriverGetPageResponse.code) &&
        Objects.equals(this.message, rmsDriverGetPageResponse.message) &&
        Objects.equals(this.data, rmsDriverGetPageResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetPageResponse {\n");
    
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
