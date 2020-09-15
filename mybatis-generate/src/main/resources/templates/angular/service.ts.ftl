import { Injectable } from '@angular/core';
import { E8HttpClient, C8HttpClientOptions, BaseService } from '@core';
import {
    ${table.entityName}GetPageRequest,
    ${table.entityName}GetPageResponse,
    ${table.entityName}GetTotalRequest,
    ${table.entityName}GetTotalResponse,
    ${table.entityName}SaveRequest,
    ${table.entityName}SaveResponse,
    ${table.entityName}GetModelRequest,
    ${table.entityName}GetModelResponse,
    ${table.entityName}ExistsNameRequest,
    ${table.entityName}ExistsNameResponse,
    ${table.entityName}ExistsCodeRequest,
    ${table.entityName}ExistsCodeResponse,
    ${table.entityName}UpdateStatusRequest,
    ${table.entityName}UpdateStatusResponse
} from './model/models';
@Injectable()
export class ${table.entityName}Service extends BaseService {
    private getPage_URL = 'api/rcenter/${table.entityName ? uncap_first}/getPage';
    private getTotal_URL = 'api/rcenter/${table.entityName ? uncap_first}/getTotal';
    private save_URL = 'api/rcenter/${table.entityName ? uncap_first}/save';
    private getModel_URL = 'api/rcenter/${table.entityName ? uncap_first}/getModel';
    private existsName_URL = 'api/rcenter/${table.entityName ? uncap_first}/existsName';
    private existsCode_URL = 'api/rcenter/${table.entityName ? uncap_first}/existsCode';
    private exportExcel_URL = 'api/rcenter/${table.entityName ? uncap_first}/exportExcel';
    private updateStatus_URL= 'api/rcenter/${table.entityName ? uncap_first}/updateStatus';
    constructor(private client: E8HttpClient) {
        super();
    }
    getPage(request: ${table.entityName}GetPageRequest, options?: C8HttpClientOptions): Promise<${table.entityName}GetPageResponse> {
        return this.client.post(this.getPage_URL, request, options);
    }
    getTotal(request: ${table.entityName}GetTotalRequest, options?: C8HttpClientOptions): Promise<${table.entityName}GetTotalResponse> {
        return this.client.post(this.getTotal_URL, request, options);
    }
    save(request: ${table.entityName}SaveRequest, options?: C8HttpClientOptions): Promise<${table.entityName}SaveResponse> {
        return this.client.post(this.save_URL, request, options);
    }
    getModel(request: ${table.entityName}GetModelRequest, options?: C8HttpClientOptions): Promise<${table.entityName}GetModelResponse> {
        return this.client.post(this.getModel_URL, request, options);
    }
    existsName(request: ${table.entityName}ExistsNameRequest, options?: C8HttpClientOptions): Promise<${table.entityName}ExistsNameResponse> {
        return this.client.post(this.existsName_URL, request, options);
    }
    existsCode(request: ${table.entityName}ExistsCodeRequest, options?: C8HttpClientOptions): Promise<${table.entityName}ExistsCodeResponse> {
        return this.client.post(this.existsCode_URL, request, options);
    }
    exportExcel(source: any) {
        return this.client.exportExcel(this.exportExcel_URL, source);
    }
    updateStatus(request: ${table.entityName}UpdateStatusRequest, options?: C8HttpClientOptions): Promise<${table.entityName}UpdateStatusResponse> {
        return this.client.post(this.updateStatus_URL, request, options);
    }
}