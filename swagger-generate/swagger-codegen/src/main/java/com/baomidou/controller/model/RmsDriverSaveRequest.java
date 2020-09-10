package com.baomidou.controller.model;

import java.util.Objects;
import com.baomidou.controller.model.RmsDriverSaveModel;
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
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
