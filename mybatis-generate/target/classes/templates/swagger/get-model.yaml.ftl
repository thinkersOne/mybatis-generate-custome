swagger: 2.0
definitions:
  ${table.entityName}GetModelRequest:
    description:
    type: object
    properties:
      id:
        description: id
        type: integer
        format: int64
  ${table.entityName}GetModelResponse:
    description:
    type: object
    properties:
      code:
        description: 1:成功
        type: integer
      message:
        description: return message
        type: string
      data:
        description: 保存数据模型
        type: object
        $ref: './common.yaml#/definitions/${table.entityName}SaveModel'