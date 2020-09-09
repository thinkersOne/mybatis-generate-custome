package com.baomidou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 * 用户操作日志 前端控制器
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-09
 */
@RestController
@RequestMapping("/log")
public class LogController implements LogControllerApi{
    final static int MAX_IMPORT_SIZE = 1000;
    @Autowired
    LogControllerService service;
    
    @Override
        public ResponseEntity<LogControllerGetPageResponse> getPage(@RequestBody LogControllerGetPageRequest request) {
    
            return new ResponseEntity<>(service.getPage(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<LogControllerGetTotalResponse> getTotal(@RequestBody LogControllerGetTotalRequest request) {
            return new ResponseEntity<>(service.getTotal(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<LogControllerSaveResponse> save(@RequestBody LogControllerSaveRequest request) {
            return new ResponseEntity<>(service.save(request,this.getUserInfo()), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<LogControllerUpdateStatusResponse> updateStatus(@RequestBody LogControllerUpdateStatusRequest request) {
            return new ResponseEntity<>(service.updateStatus(request), HttpStatus.OK);
        }

        @Override
        public ResponseEntity<LogControllerExistsCodeResponse> existsCode(@RequestBody LogControllerExistsCodeRequest request) {
            LogControllerExistsCodeResponse response = new LogControllerExistsCodeResponse();
            boolean result = service.existsCode(request.getCode(), request.getId());
            response.setCode(Response.OK);
            response.setData(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @Override
        public ResponseEntity<LogControllerExistsNameResponse> existsName(@RequestBody LogControllerExistsNameRequest request) {
            LogControllerExistsNameResponse response = new LogControllerExistsNameResponse();
            boolean result = service.existsName(request.getName(), request.getId());
            response.setCode(Response.OK);
            response.setData(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<LogControllerGetModelResponse> getModel(@RequestBody LogControllerGetModelRequest request) {
            return new ResponseEntity<>(service.getModel(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<Response> importExcel(MultipartFile file) {
            Response response = new Response();
            String fileName = file.getOriginalFilename();
            if (fileName != null && !(fileName.contains(".xls") || fileName.contains(".xlsx"))) {
                return new ResponseEntity<>(Response.failed("传入的件格式有误"), HttpStatus.OK);
            }
            ExcelFileInfo<LogControllerSaveModel> info = service.getImportMeta();
            List<Map<String, Object>> listError = new ArrayList<>();
            List<LogControllerSaveModel> list = null;
            try {
                list = ExcelImportUtil.excelToList(file.getInputStream(), info, listError, LogControllerSaveModel.class);
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
                LogControllerGetPageParam pageParam = new LogControllerGetPageParam();
                if (null != source) {
                    //查询参数
                    pageParam = JsonUtils.toObject(source, LogControllerGetPageParam.class);
                }
                //文件名
                String fileName = "车型" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                //导出数据源
                List<LogControllerGetPageModel> dataSource = service.getExportDataSource(pageParam);
                //调用service查询方法返回结果集
                ServletOutputStream out = response.getOutputStream();
                ExcelFileInfo<LogControllerGetPageModel> info = service.getExportMeta(fileName,dataSource);
                ExportExcelUtil.exportExcel(response, info);
            } catch (Exception ex) {
            logger.error("导出失败", ex);
            responseResult.setCode(Response.Fail);
            responseResult.setMessage("导出失败");
            }
            return new ResponseEntity<>(responseResult, HttpStatus.OK);
        }

}
