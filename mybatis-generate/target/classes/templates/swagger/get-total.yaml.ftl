swagger: 2.0
definitions:
  ${table.entityName}GetTotalRequest:
    description:
    type: object
    properties:
      queryParam:
        description: 查询参数
        type: object
        $ref: './common.yaml#/definitions/${table.entityName}GetPageParam'
  ${table.entityName}GetTotalResponse:
    description:
    type: object
    properties:
      code:
        description: 1成功  0失败
        type: integer
      message:
        description: return message
        type: string
      total:
        description: 总数量
        type: integer
        format: int64