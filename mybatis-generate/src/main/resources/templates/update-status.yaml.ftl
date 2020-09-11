swagger: 2.0
definitions:
  ${table.entityName}UpdateStatusRequest:
    description:
    type: object
    properties:
      id:
        description: id
        type: integer
        format: int64
      status:
        description: 1:启用 0：停用
        type: integer
  ${table.entityName}UpdateStatusResponse:
    description:
    type: object
    properties:
      code:
        description: 1成功
        type: integer
      message:
        description: return message
        type: string