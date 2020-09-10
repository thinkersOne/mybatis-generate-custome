package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import ${package.Parent}.swagger.api.${table.entityName}Api;
import ${package.Service}.api.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} implements ${table.entityName}Api {
<#else>
public class ${table.controllerName} implements ${table.entityName}Api{
</#if>
    final static int MAX_IMPORT_SIZE = 1000;
    @Autowired
    ${table.serviceName} service;
    
    @Override
        public ResponseEntity<${table.entityName}GetPageResponse> getPage(@RequestBody ${table.entityName}GetPageRequest request) {
            return new ResponseEntity<>(service.getPage(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<${table.entityName}GetTotalResponse> getTotal(@RequestBody ${table.entityName}GetTotalRequest request) {
            return new ResponseEntity<>(service.getTotal(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<${table.entityName}SaveResponse> save(@RequestBody ${table.entityName}SaveRequest request) {
            return new ResponseEntity<>(service.save(request,this.getUserInfo()), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<${table.entityName}UpdateStatusResponse> updateStatus(@RequestBody ${table.entityName}UpdateStatusRequest request) {
            return new ResponseEntity<>(service.updateStatus(request), HttpStatus.OK);
        }

        @Override
        public ResponseEntity<${table.entityName}ExistsCodeResponse> existsCode(@RequestBody ${table.entityName}ExistsCodeRequest request) {
            ${table.entityName}ExistsCodeResponse response = new ${table.entityName}ExistsCodeResponse();
            boolean result = service.existsCode(request.getCode(), request.getId());
            response.setCode(Response.OK);
            response.setData(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @Override
        public ResponseEntity<${table.entityName}ExistsNameResponse> existsName(@RequestBody ${table.entityName}ExistsNameRequest request) {
            ${table.entityName}ExistsNameResponse response = new ${table.entityName}ExistsNameResponse();
            boolean result = service.existsName(request.getName(), request.getId());
            response.setCode(Response.OK);
            response.setData(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<${table.entityName}GetModelResponse> getModel(@RequestBody ${table.entityName}GetModelRequest request) {
            return new ResponseEntity<>(service.getModel(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<Response> importExcel(MultipartFile file) {
            Response response = new Response();
            String fileName = file.getOriginalFilename();
            if (fileName != null && !(fileName.contains(".xls") || fileName.contains(".xlsx"))) {
                return new ResponseEntity<>(Response.failed("传入的件格式有误"), HttpStatus.OK);
            }
            ExcelFileInfo<${table.entityName}SaveModel> info = service.getImportMeta();
            List<Map<String, Object>> listError = new ArrayList<>();
            List<${table.entityName}SaveModel> list = null;
            try {
                list = ExcelImportUtil.excelToList(file.getInputStream(), info, listError, ${table.entityName}SaveModel.class);
            } catch (Exception e) {
                this.logger.error("导入Excel失败:", e);
            }
            if (list.size() > MAX_IMPORT_SIZE) {
                Response.failed("最大导入不能超过" + MAX_IMPORT_SIZE);
            }
            if (list.size() == 0) {
                return new ResponseEntity<>(Response.failed("无导入数据"), HttpStatus.OK);
            }
            return null;
        }
    
        @Override
        public ResponseEntity<Response> exportExcel(String source)  {
            Response responseResult = new Response();
            try {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = servletRequestAttributes.getRequest();
                HttpServletResponse response = servletRequestAttributes.getResponse();
                ${table.entityName}GetPageParam pageParam = new ${table.entityName}GetPageParam();
                if (null != source) {
                    //查询参数
                    pageParam = JsonUtils.toObject(source, ${table.entityName}GetPageParam.class);
                }
                //文件名
                String fileName = "车型" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                //导出数据源
                List<${table.entityName}GetPageModel> dataSource = service.getExportDataSource(pageParam);
                //调用service查询方法返回结果集
                ServletOutputStream out = response.getOutputStream();
                ExcelFileInfo<${table.entityName}GetPageModel> info = service.getExportMeta(fileName,dataSource);
                ExportExcelUtil.exportExcel(response, info);
            } catch (Exception ex) {
                logger.error("导出失败", ex);
                responseResult.setCode(Response.Fail);
                responseResult.setMessage("导出失败");
            }
            return new ResponseEntity<>(responseResult, HttpStatus.OK);
        }

}
</#if>
