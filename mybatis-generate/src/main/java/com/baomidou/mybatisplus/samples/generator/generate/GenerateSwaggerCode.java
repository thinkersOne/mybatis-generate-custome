package com.baomidou.mybatisplus.samples.generator.generate;
public class GenerateSwaggerCode {

    /**
     * 运单 导入 非固定 目的地、重量、体积、地址
     * @param transportPortName
     * @param volume
     * @param weight
     * @param address
     * @param count
     */
    public static void printStr(String transportPortName,String volume,String weight,
                                String address,String quantity,int count){
        for (int i = 0; i < count; i++) {
            //目的地
//            System.out.printf("%s",transportPortName+(i+1)+":\n");
//            System.out.printf("%s","  description: 目的地"+(i+1)+"\n");
//            System.out.printf("%s","  type: string"+"\n");
//            System.out.printf("%s","  format:"+"\n");
//            //体积
//            System.out.printf("%s",volume+(i+1)+":\n");
//            System.out.printf("%s","  description: 体积"+(i+1)+"\n");
//            System.out.printf("%s","  type: string"+"\n");
//            System.out.printf("%s","  format:"+"\n");
//            //重量
//            System.out.printf("%s",weight+(i+1)+":\n");
//            System.out.printf("%s","  description: 重量"+(i+1)+"\n");
//            System.out.printf("%s","  type: string"+"\n");
//            System.out.printf("%s","  format:"+"\n");
//            //地址
//            System.out.printf("%s",address+(i+1)+":\n");
//            System.out.printf("%s","  description: 地址"+(i+1)+"\n");
//            System.out.printf("%s","  type: string"+"\n");
//            System.out.printf("%s","  format:"+"\n");
            //数量
            System.out.printf("%s",quantity+(i+1)+":\n");
            System.out.printf("%s","  description: 数量"+(i+1)+"\n");
            System.out.printf("%s","  type: string"+"\n");
            System.out.printf("%s","  format:"+"\n");
        }
    }


    /**
     * 根据 模块、接口名生成 index内容
     * @param description
     * @param templateName
     * @param apiName
     */
    public static void printIndex(String description,String templateName,String apiName){
        StringBuffer sb = new StringBuffer();
        System.out.printf("%s","  #" + description + "\n");
        System.out.printf("%s","  " + templateName + "/" + apiName + ":\n");
        System.out.printf("%s","    $ref: '../apis/" + GenerateUtils.humpToUnderline(templateName)
            +"/"+ GenerateUtils.humpToUnderline(templateName)+"-api.yaml#/paths/"+apiName+"'");
    }

    /**
     * 上传
     * @param templateName
     * @param apiName
     */
    public static void printDownload(String templateName,String apiName){
        System.out.printf("%s","  " + apiName + ":\n");
        System.out.printf("%s","    "+"post:\n");
        System.out.printf("%s","      summary: 下载模板\n");
        System.out.printf("%s","      operationId: "+apiName+"\n");
        System.out.printf("%s","      consumes:\n");
        System.out.printf("%s","        - application/x-www-form-urlencoded\n");
        System.out.printf("%s","      responses:\n");
        System.out.printf("%s","        '200':\n");
        System.out.printf("%s","          description: 一般返回\n");
        System.out.printf("%s","          schema:\n");
        System.out.printf("%s","            $ref: '../models/response.yaml#/definitions/Response'\n");
        System.out.printf("%s","      tags:\n");
        System.out.printf("%s","        - "+ GenerateUtils.captureName(templateName));
    }

    /**
     * 导入
     * @param templateName
     * @param apiName
     */
    public static void printImport(String templateName,String apiName){
        System.out.printf("%s","  " + apiName + ":\n");
        System.out.printf("%s","    "+"post:\n");
        System.out.printf("%s","      summary: 导入\n");
        System.out.printf("%s","      operationId: "+apiName+"\n");
        System.out.printf("%s","      consumes:\n");
        System.out.printf("%s","        - multipart/form-data\n");
        System.out.printf("%s","      parameters:\n");
        System.out.printf("%s","        - name: file\n");
        System.out.printf("%s","          in: formData\n");
        System.out.printf("%s","          type: file\n");
        System.out.printf("%s","          required: true\n");
        System.out.printf("%s","          description: 文件\n");
        System.out.printf("%s","      responses:\n");
        System.out.printf("%s","        '200':\n");
        System.out.printf("%s","          description: 一般返回\n");
        System.out.printf("%s","          schema:\n");
        System.out.printf("%s","            $ref: '../models/response.yaml#/definitions/Response'\n");
        System.out.printf("%s","      tags:\n");
        System.out.printf("%s","        - "+ GenerateUtils.captureName(templateName));
    }



    public static void main(String[] args) {
        //index
//        printIndex("导入外部单号","tmsOrder","importOuterCode");
//        printIndex("外部单号导入模板","tmsOrder","downloadTemplateOuterCode");

        //导入
//        printImport("tmsOrder","importOuterCode");

//        printDownload("tmsOrder","downloadTemplateOuterCode");

        printStr("transportPortName","volume","weight","address","quantity",50);

    }

}
