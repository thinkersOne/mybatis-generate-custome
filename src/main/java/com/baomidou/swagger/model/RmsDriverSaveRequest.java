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
public class RmsDriverSaveRequest   {
  @JsonProperty("model")
  private RmsDriverSaveModel model = null;

  public RmsDriverSaveRequest model(RmsDriverSaveModel model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(value = "")

  @Valid
  public RmsDriverSaveModel getModel() {
    return model;
  }

  public void setModel(RmsDriverSaveModel model) {
    this.model = model;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RmsDriverSaveRequest rmsDriverSaveRequest = (RmsDriverSaveRequest) o;
    return Objects.equals(this.model, rmsDriverSaveRequest.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RmsDriverSaveRequest {\n");

    sb.append("    model: ").append(toIndentedString(model)).append("\n");
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
