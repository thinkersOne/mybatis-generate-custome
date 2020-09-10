package com.baomidou.mybatisplus.samples.generator.generate;

public class GenerateBusinessCode {

    public static void printTmsDeliveryModel(int count){
        for (int i = 0; i < count; i++) {
            System.out.printf("%s","if (!org.springframework.util.StringUtils.isEmpty(v.getTransportPortName"+(i+1)+"())){\n");
            System.out.printf("%s","  tmsDeliveryOrderModels.add(new TmsDeliveryOrderModel(v.getTransportPortName"+(i+1)+
                    "(),v.getVolume"+(i+1)+"(),v.getWeight"+(i+1)+"(),v.getAddress"+(i+1)+"(),v.getQuantity"+(i+1)+"()));\n");
            System.out.printf("%s","}\n");
        }
    }

    public static void printTransportPointName(int count){
        for (int i = 0; i < count; i++) {
            System.out.printf("%s","if(!org.springframework.util.StringUtils.isEmpty(tmsOrderSaveModel.getTransportPortName"+(i+1)+"())){\n");
            System.out.printf("%s","  transportPointNames.add(tmsOrderSaveModel.getTransportPortName"+(i+1)+"());\n");
            System.out.printf("%s","}\n");
        }
    }

    public static void printImportStr(String description1,String str1,String description2,String str2,
                                      String description3,String str3,
                                      String description4,String str4,
                                      String description5,String str5,
                                      int count){
        for (int i = 0; i < count; i++) {
            //目的地
            System.out.printf("%s","info.addExcelColumn(\""+description1+(i+1) + "\",\""+ str1+(i+1)+"\");\n");
            //重量
            System.out.printf("%s","info.addExcelColumn(\""+description2+(i+1) + "\",\""+ str2+(i+1)+"\");\n");
            //体积
            System.out.printf("%s","info.addExcelColumn(\""+description3+(i+1) + "\",\""+ str3+(i+1)+"\");\n");
            //数量
            System.out.printf("%s","info.addExcelColumn(\""+description4+(i+1) + "\",\""+ str4+(i+1)+"\");\n");
            //地址
            System.out.printf("%s","info.addExcelColumn(\""+description5+(i+1) + "\",\""+ str5+(i+1)+"\");\n");
        }
    }



    public static void main(String[] args) {
//        printImportStr("目的地","transportPortName","重量","weight",
//                "体积","volume","数量","quantity","地址","address",50);
//        printTransportPointName(50);
        printTmsDeliveryModel(50);
    }

}
