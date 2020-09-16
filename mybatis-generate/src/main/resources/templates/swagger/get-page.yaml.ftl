swagger: 2.0
definitions:
  ${table.entityName}GetPageRequest:
    description:
    type: object
    properties:
      pageParam:
        description: 分页参数
        type: object
        $ref: '../../../models/common/page-param.yaml#/definitions/PageParam'
      queryParam:
        description: 查询参数
        type: object
        $ref: './common.yaml#/definitions/${table.entityName}GetPageParam'
  ${table.entityName}GetPageResponse:
    description:
    type: object
    properties:
      code:
        description: 1成功  -1失败
        type: integer
      message:
        description: return message
        type: string
      data:
        description: 信息
        type: array
        items:
          $ref: '#/definitions/${table.entityName}GetPageModel'
  ${table.entityName}GetPageModel:
    description:
    type: object
    properties: 
    <#list table.fields as f>
    <#if f.type ?contains("bigint")>
      ${f.propertyName}:
        description: ${f.comment}
        type: integer
        format: int64
    <#elseif f.type ?contains("varchar")>
      ${f.propertyName}:
        description: ${f.comment}
        type: string
        format:
    <#elseif f.type ?contains('int')>
      ${f.propertyName}:
        description: ${f.comment}
        type: integer
        format:
    <#elseif f.type ?contains("decimal")>
      ${f.propertyName}:
        description: ${f.comment}
        type: number
        format: double
    <#elseif f.type ?contains("date")>
      ${f.propertyName}:
        description: ${f.comment}
        type: string
        format: date
    <#elseif f.type ?contains("timestamp")>
      ${f.propertyName}:
        description: ${f.comment}
        type: string
        format: date
    </#if>
    </#list>