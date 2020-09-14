swagger: 2.0
info:
  title: Xforce+ athena API
  description: Xforce+ athena API 3.0
  version: 1.0
host: 118.178.134.104:8081
basePath: "/api-v1"
schemes:
- http
- https
#basePath: /v1
tags:
- name: Mobile Purchaser
  description: 企业版
produces:
- application/json
consumes:
- application/json
securityDefinitions:
  X-Access-Token:
    type: apiKey
    name: X-Access-Token
    in: header
  X-Operation-Token:
    type: apiKey
    name: X-Operation-Token
    in: header
security:
- X-Access-Token: []
- X-Operation-Token: []
paths:
  #################${table.comment}###############
  # 获取当前页
  ${table.entityName ? uncap_first}/getPage:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/getPage'
  # 获取总数
  ${table.entityName ? uncap_first}/getTotal:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/getTotal'
  # 保存
  ${table.entityName ? uncap_first}/save:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/save'
  # 名称是否存在
  ${table.entityName ? uncap_first}/existsName:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/existsName'
  # 编码是否存在
  ${table.entityName ? uncap_first}/existsCode:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/existsCode'
  # 获取保存模型
  ${table.entityName ? uncap_first}/getModel:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/getModel'
  # 导入
  ${table.entityName ? uncap_first}/importExcel:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/importExcel'
    # 导出
  ${table.entityName ? uncap_first}/exportExcel:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/exportExcel'
  ${table.entityName ? uncap_first}/downloadTemplate:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/downloadTemplate'
  #更新状态
  ${table.entityName ? uncap_first}/updateStatus:
    $ref: '../apis/${table.name ? replace("_","-")}/${table.name ? replace("_","-")}-api.yaml#/paths/updateStatus'
