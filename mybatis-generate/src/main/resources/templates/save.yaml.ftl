swagger: 2.0
definitions:
  ${table.entityName}SaveRequest:
    description:
    type: object
    properties:
      model:
        description: 保存数据模型
        type: object
        $ref: './common.yaml#/definitions/${table.entityName}SaveModel'
  ${table.entityName}SaveResponse:
    description:
    type: object
    properties:
      code:
        description: 1成功  0失败
        type: integer
      message:
        description: return message
        type: string
      data:
        description: id
        type: integer
        format: int64