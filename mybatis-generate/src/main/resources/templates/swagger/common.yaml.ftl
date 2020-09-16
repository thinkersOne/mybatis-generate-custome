swagger: 2.0
definitions:
  ${table.entityName}GetPageParam:
    description:
    type: object
    properties:
      keyword:
        description: 名称 编码
        type: string
  ${table.entityName}SaveModel:
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
