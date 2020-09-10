package com.baomidou.controller.model;

import java.util.Objects;
import com.baomidou.controller.model.RmsDriverGetPageParam;
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
public class RmsDriverGetTotalRequest   {
  @JsonProperty("queryParam")
  private RmsDriverGetPageParam queryParam = null;

  public RmsDriverGetTotalRequest queryParam(RmsDriverGetPageParam queryParam) {
    this.queryParam = queryParam;
    return this;
  }

  /**
   * Get queryParam
   * @return queryParam
  **/
  @ApiModelProperty(value = "")

  @Valid
  public RmsDriverGetPageParam getQueryParam() {
    return queryParam;
  }

  public void setQueryParam(RmsDriverGetPageParam queryParam) {
    this.queryParam = queryParam;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverGetTotalRequest rmsDriverGetTotalRequest = (RmsDriverGetTotalRequest) o;
    return Objects.equals(this.queryParam, rmsDriverGetTotalRequest.queryParam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queryParam);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetTotalRequest {\n");
    
    sb.append("    queryParam: ").append(toIndentedString(queryParam)).append("\n");
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
