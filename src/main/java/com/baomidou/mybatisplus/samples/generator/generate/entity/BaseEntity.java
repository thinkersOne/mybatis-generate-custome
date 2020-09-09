package com.baomidou.mybatisplus.samples.generator.generate.entity;


import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    private Long id;
    private Long tenantId;

    public Long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    protected BaseEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
