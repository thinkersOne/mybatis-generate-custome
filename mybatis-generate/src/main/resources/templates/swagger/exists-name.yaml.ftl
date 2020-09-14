swagger: 2.0
definitions:
  ${table.entityName}ExistsNameRequest:
    description:
    type: object
    properties:
      id:
        description: id
        type: integer
        format: int64
      name:
        description: 名称
        type: string
  ${table.entityName}ExistsNameResponse:
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