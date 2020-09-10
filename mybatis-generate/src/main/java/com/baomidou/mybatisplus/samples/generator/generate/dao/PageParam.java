package com.baomidou.mybatisplus.samples.generator.generate.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@ApiModel(description = "null")

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class PageParam {
    @JsonProperty("pageIndex")
    private Integer pageIndex = null;

    @JsonProperty("pageSize")
    private Integer pageSize = null;

    @JsonIgnore
    public PageParam pageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    /**
     * 当前页
     *
     * @return pageIndex
     **/
    @ApiModelProperty(value = "当前页")
    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    @JsonIgnore
    public PageParam pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 每页数量
     *
     * @return pageSize
     **/
    @ApiModelProperty(value = "每页数量")
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
