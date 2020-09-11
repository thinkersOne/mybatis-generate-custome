swagger: 2.0
paths:
  getPage: #/${table.entityName ? uncap_first}/getPage:
    post:
      summary:
      operationId: getPage
      parameters:
        - name: request
          in: body
          required: true
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/get-page.yaml#/definitions/${table.entityName}GetPageRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/get-page.yaml#/definitions/${table.entityName}GetPageResponse'
      tags:
        - ${table.entityName}
  getTotal: #/${table.entityName ? uncap_first}/getTotal:
    post:
      summary:
      operationId: getTotal
      parameters:
      - name: request
        in: body
        required: true
        description:
        schema:
          $ref: '../apis/${table.name ? replace("_","-")}/model/get-total.yaml#/definitions/${table.entityName}GetTotalRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/get-total.yaml#/definitions/${table.entityName}GetTotalResponse'
      tags:
      - ${table.entityName}
  save: #/${table.entityName ? uncap_first}/save:
    post:
      summary:
      operationId: save
      parameters:
      - name: request
        in: body
        required: true
        description:
        schema:
          $ref: '../apis/${table.name ? replace("_","-")}/model/save.yaml#/definitions/${table.entityName}SaveRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/save.yaml#/definitions/${table.entityName}SaveResponse'
      tags:
      - ${table.entityName}
  getModel: #/${table.entityName ? uncap_first}/getModel:
    post:
      summary:
      operationId: getModel
      parameters:
      - name: request
        in: body
        required: true
        description:
        schema:
          $ref: '../apis/${table.name ? replace("_","-")}/model/get-model.yaml#/definitions/${table.entityName}GetModelRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/get-model.yaml#/definitions/${table.entityName}GetModelResponse'
      tags:
      - ${table.entityName}
  existsName: #/${table.entityName ? uncap_first}/existsName:
    post:
      summary:
      operationId: existsName
      parameters:
      - name: request
        in: body
        required: true
        description:
        schema:
          $ref: '../apis/${table.name ? replace("_","-")}/model/exists-name.yaml#/definitions/${table.entityName}ExistsNameRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/exists-name.yaml#/definitions/${table.entityName}ExistsNameResponse'
      tags:
      - ${table.entityName}
  existsCode: #/${table.entityName ? uncap_first}/existsCode:
    post:
      summary:
      operationId: existsCode
      parameters:
      - name: request
        in: body
        required: true
        description:
        schema:
          $ref: '../apis/${table.name ? replace("_","-")}/model/exists-code.yaml#/definitions/${table.entityName}ExistsCodeRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/exists-code.yaml#/definitions/${table.entityName}ExistsCodeResponse'
      tags:
      - ${table.entityName}
  importExcel: #/${table.entityName ? uncap_first}/importExcel
    post:
      summary: 导入
      operationId: importExcel
      consumes:
      - multipart/form-data
      parameters:
      - name: file
        in: formData
        type: file
        required: true
        description: 文件
      responses:
        '200':
          description: 一般返回
          schema:
            $ref: '../models/response.yaml#/definitions/Response'
      tags:
      - ${table.entityName}
  exportExcel: #/${table.entityName ? uncap_first}/exportExcel
    post:
      summary: 导出
      operationId: exportExcel
      consumes:
      - application/x-www-form-urlencoded
      parameters:
      - name: source
        in: formData
        type: string
        required: true
        description: 参数
      tags:
      - ${table.entityName}
  downloadTemplate: #/${table.entityName ? uncap_first}/downloadTemplate
    post:
      summary: 导出
      operationId: downloadTemplate
      consumes:
        - application/x-www-form-urlencoded
      tags:
        - ${table.entityName}
  updateStatus: #/${table.entityName ? uncap_first}/updateStatus:
    post:
      summary:
      operationId: updateStatus
      parameters:
      - name: request
        in: body
        required: true
        description:
        schema:
          $ref: '../apis/${table.name ? replace("_","-")}/model/update-status.yaml#/definitions/${table.entityName}UpdateStatusRequest'
      responses:
        '200':
          description:
          schema:
            $ref: '../apis/${table.name ? replace("_","-")}/model/update-status.yaml#/definitions/${table.entityName}UpdateStatusResponse'
      tags:
      - ${table.entityName}