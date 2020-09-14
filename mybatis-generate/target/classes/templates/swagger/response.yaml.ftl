swagger: 2.0
definitions:
  BaseResponse:
    discriminator: code
    description: base Response object
    type: object
    properties:
      code:
        default: 1
        description: return code
        type: integer
        format: int32
      message:
        default: "成功"
        description: return message
        type: string
      info:
        default: ""
        description: err message
        type: string
  Response:
    description: general Response object
    type: object
    properties:
      code:
        description: return code
        type: integer
        format: int32
      message:
        description: return message
        type: string
      result:
        description: |
          result
        type: string