import { Injectable } from '@angular/core';
import { E8HttpClient, C8HttpClientOptions, BaseService } from '@core';
import {
    RmsVehicleGetPageRequest,
    RmsVehicleGetPageResponse,
    RmsVehicleGetTotalRequest,
    RmsVehicleGetTotalResponse,
    RmsVehicleSaveRequest,
    RmsVehicleSaveResponse,
    RmsVehicleGetModelRequest,
    RmsVehicleGetModelResponse,
    RmsVehicleExistsNameRequest,
    RmsVehicleExistsNameResponse,
    RmsVehicleExistsCodeRequest,
    RmsVehicleExistsCodeResponse,
    RmsVehicleUpdateStatusRequest,
    RmsVehicleUpdateStatusResponse
} from './model/models';
@Injectable()
export class RmsVehicleService extends BaseService {
    private getPage_URL = 'api/rcenter/rmsVehicle/getPage';
    private getTotal_URL = 'api/rcenter/rmsVehicle/getTotal';
    private save_URL = 'api/rcenter/rmsVehicle/save';
    private getModel_URL = 'api/rcenter/rmsVehicle/getModel';
    private existsName_URL = 'api/rcenter/rmsVehicle/existsName';
    private existsCode_URL = 'api/rcenter/rmsVehicle/existsCode';
    private exportExcel_URL = 'api/rcenter/rmsVehicle/exportExcel';
    private updateStatus_URL= 'api/rcenter/rmsVehicle/updateStatus';
    constructor(private client: E8HttpClient) {
        super();
    }
    getPage(request: RmsVehicleGetPageRequest, options?: C8HttpClientOptions): Promise<RmsVehicleGetPageResponse> {
        return this.client.post(this.getPage_URL, request, options);
    }
    getTotal(request: RmsVehicleGetTotalRequest, options?: C8HttpClientOptions): Promise<RmsVehicleGetTotalResponse> {
        return this.client.post(this.getTotal_URL, request, options);
    }
    save(request: RmsVehicleSaveRequest, options?: C8HttpClientOptions): Promise<RmsVehicleSaveResponse> {
        return this.client.post(this.save_URL, request, options);
    }
    getModel(request: RmsVehicleGetModelRequest, options?: C8HttpClientOptions): Promise<RmsVehicleGetModelResponse> {
        return this.client.post(this.getModel_URL, request, options);
    }
    existsName(request: RmsVehicleExistsNameRequest, options?: C8HttpClientOptions): Promise<RmsVehicleExistsNameResponse> {
        return this.client.post(this.existsName_URL, request, options);
    }
    existsCode(request: RmsVehicleExistsCodeRequest, options?: C8HttpClientOptions): Promise<RmsVehicleExistsCodeResponse> {
        return this.client.post(this.existsCode_URL, request, options);
    }
    exportExcel(source: any) {
        return this.client.exportExcel(this.exportExcel_URL, source);
    }
    updateStatus(request: RmsVehicleUpdateStatusRequest, options?: C8HttpClientOptions): Promise<RmsVehicleUpdateStatusResponse> {
        return this.client.post(this.updateStatus_URL, request, options);
    }
}