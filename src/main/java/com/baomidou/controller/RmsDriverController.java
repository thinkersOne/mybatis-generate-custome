package com.baomidou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.service.api.RmsDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 * 司机 前端控制器
 * </p>
 *
 * @author lizhihao
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/rms-driver")
public class RmsDriverController implements RmsDriverApi{
    final static int MAX_IMPORT_SIZE = 1000;
    @Autowired
    RmsDriverService service;
    
    @Override
        public ResponseEntity<RmsDriverGetPageResponse> getPage(@RequestBody RmsDriverGetPageRequest request) {
            return new ResponseEntity<>(service.getPage(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<RmsDriverGetTotalResponse> getTotal(@RequestBody RmsDriverGetTotalRequest request) {
            return new ResponseEntity<>(service.getTotal(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<RmsDriverSaveResponse> save(@RequestBody RmsDriverSaveRequest request) {
            return new ResponseEntity<>(service.save(request,this.getUserInfo()), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<RmsDriverUpdateStatusResponse> updateStatus(@RequestBody RmsDriverUpdateStatusRequest request) {
            return new ResponseEntity<>(service.updateStatus(request), HttpStatus.OK);
        }

        @Override
        public ResponseEntity<RmsDriverExistsCodeResponse> existsCode(@RequestBody RmsDriverExistsCodeRequest request) {
            RmsDriverExistsCodeResponse response = new RmsDriverExistsCodeResponse();
            boolean result = service.existsCode(request.getCode(), request.getId());
            response.setCode(Response.OK);
            response.setData(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @Override
        public ResponseEntity<RmsDriverExistsNameResponse> existsName(@RequestBody RmsDriverExistsNameRequest request) {
            RmsDriverExistsNameResponse response = new RmsDriverExistsNameResponse();
            boolean result = service.existsName(request.getName(), request.getId());
            response.setCode(Response.OK);
            response.setData(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<RmsDriverGetModelResponse> getModel(@RequestBody RmsDriverGetModelRequest request) {
            return new ResponseEntity<>(service.getModel(request), HttpStatus.OK);
        }
    
        @Override
        public ResponseEntity<Response> importExcel(MultipartFile file) {
            Response response = new Response();
            String fileName = file.getOriginalFilename();
            if (fileName != null && !(fileName.contains(".xls") || fileName.contains(".xlsx"))) {
                return new ResponseEntity<>(Response.failed("传入的件格式有误"), HttpStatus.OK);
            }
            ExcelFileInfo<RmsDriverSaveModel> info = service.getImportMeta();
            List<Map<String, Object>> listError = new ArrayList<>();
            List<RmsDriverSaveModel> list = null;
            try {
                list = ExcelImportUtil.excelToList(file.getInputStream(), info, listError, RmsDriverSaveModel.class);
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
                RmsDriverGetPageParam pageParam = new RmsDriverGetPageParam();
                if (null != source) {
                    //查询参数
                    pageParam = JsonUtils.toObject(source, RmsDriverGetPageParam.class);
                }
                //文件名
                String fileName = "车型" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                //导出数据源
                List<RmsDriverGetPageModel> dataSource = service.getExportDataSource(pageParam);
                //调用service查询方法返回结果集
                ServletOutputStream out = response.getOutputStream();
                ExcelFileInfo<RmsDriverGetPageModel> info = service.getExportMeta(fileName,dataSource);
                ExportExcelUtil.exportExcel(response, info);
            } catch (Exception ex) {
                logger.error("导出失败", ex);
                responseResult.setCode(Response.Fail);
                responseResult.setMessage("导出失败");
            }
            return new ResponseEntity<>(responseResult, HttpStatus.OK);
        }

}
