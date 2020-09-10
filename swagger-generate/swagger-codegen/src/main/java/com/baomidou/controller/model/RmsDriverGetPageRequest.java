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
public class RmsDriverGetPageRequest   {
  @JsonProperty("pageParam")
  private com.chengju.common.dao.PageParam pageParam = null;

  @JsonProperty("queryParam")
  private RmsDriverGetPageParam queryParam = null;

  public RmsDriverGetPageRequest pageParam(com.chengju.common.dao.PageParam pageParam) {
    this.pageParam = pageParam;
    return this;
  }

  /**
   * Get pageParam
   * @return pageParam
  **/
  @ApiModelProperty(value = "")

  @Valid
  public com.chengju.common.dao.PageParam getPageParam() {
    return pageParam;
  }

  public void setPageParam(com.chengju.common.dao.PageParam pageParam) {
    this.pageParam = pageParam;
  }

  public RmsDriverGetPageRequest queryParam(RmsDriverGetPageParam queryParam) {
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
    RmsDriverGetPageRequest rmsDriverGetPageRequest = (RmsDriverGetPageRequest) o;
    return Objects.equals(this.pageParam, rmsDriverGetPageRequest.pageParam) &&
        Objects.equals(this.queryParam, rmsDriverGetPageRequest.queryParam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageParam, queryParam);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverGetPageRequest {\n");
    
    sb.append("    pageParam: ").append(toIndentedString(pageParam)).append("\n");
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
