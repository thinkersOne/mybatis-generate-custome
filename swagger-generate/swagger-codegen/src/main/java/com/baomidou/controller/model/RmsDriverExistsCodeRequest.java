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
public class RmsDriverExistsCodeRequest   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("code")
  private String code = null;

  public RmsDriverExistsCodeRequest id(Long id) {
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

  public RmsDriverExistsCodeRequest code(String code) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverExistsCodeRequest rmsDriverExistsCodeRequest = (RmsDriverExistsCodeRequest) o;
    return Objects.equals(this.id, rmsDriverExistsCodeRequest.id) &&
        Objects.equals(this.code, rmsDriverExistsCodeRequest.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverExistsCodeRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
