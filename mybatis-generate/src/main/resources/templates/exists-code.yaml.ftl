swagger: 2.0
definitions:
  ${table.entityName}ExistsCodeRequest:
    description:
    type: object
    properties:
      id:
        description: id
        type: integer
        format: int64
      code:
        description: 编码
        type: string
  ${table.entityName}ExistsCodeResponse:
    description:
    type: object
    properties:
      code:
        description: 1成功
        type: integer
      message:
        description: return message
        type: string
      data:
        description: 是否存在
        type: boolean