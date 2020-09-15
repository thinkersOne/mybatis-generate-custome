import { Component, ViewChild } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd';
import { STColumn, STData, STChange, STComponent } from '@delon/abc';
import {  ModalHelper } from '@delon/theme';
import { RmsVehicleService } from './service/rms-vehicle.service';
import { RmsVehicleGetTotalRequest, RmsVehicleGetPageModel, RmsVehicleGetPageRequest,RmsVehicleUpdateStatusRequest } from './service/model/models';
import { RmsVehicleEditComponent } from './edit/rms-vehicle-edit.component';
import { RmsVehicleImportComponent } from './import/rms-vehicle-import.component';
import { SFSchema } from '@delon/form';

@Component({
  selector: 'rms-vehicle',
  templateUrl: './rms-vehicle.component.html',
  styleUrls: ['./rms-vehicle.component.css'],
  // changeDetection: ChangeDetectionStrategy,
})
export class RmsVehicleComponent {
  @ViewChild(STComponent, { static: false })
  st: STComponent;
 formData: any={};
  parameter: any = {};
  currentSysOrgId = '';
  data: any[] = []; // 数据源
  total:any = 0;
  columns: STColumn[] = [
        {title: '', index: 'id', width: 100},
        {title: '组织机构id', index: 'sysOrgId', width: 100},
        {title: '车牌号', index: 'license', width: 100},
        {title: '车队', index: 'rmsMotorcadeId', width: 100},
        {title: '运输状态', index: 'taskStatus', width: 100},
        {title: '车辆类型 0:燃油车 1:新能源', index: 'energyType', width: 100},
        {title: '车辆来源 0:自有车辆 1：社会车辆', index: 'sourceType', width: 100},
        { title: '状态 0:停用 1:启用', index: 'status', width: 80, format:(item: STData, col: STColumn, index: number)=>{
          if(item.status===1){
              return "已启用";
          } else {
              return "已停用";
          }
        }},
        {title: '0:未授权 1：已授权', index: 'authStatus', width: 100},
        {title: '车型', index: 'vehicleTypeId', width: 100},
        {title: '车长(m)', index: 'length', width: 100},
        {title: '车宽(m)', index: 'width', width: 100},
        {title: '车高(m)', index: 'height', width: 100},
        {title: '载重(kg)', index: 'ratedLoad', width: 100},
        {title: '体积(m3)', index: 'ratedVolume', width: 100},
        {title: '车辆品牌(新能源车)', index: 'vehicleBrandId', width: 100},
        {title: '创建人', index: 'createUser', width: 100},
        {title: '修改人', index: 'updateUser', width: 100},
        {title: '创建日期', index: 'createTime',type: 'date', width: 130},
        {title: '修改日期', index: 'updateTime',type: 'date', width: 130},
        {title: '租户', index: 'tenantId', width: 100},
        {title: '道路运输证号', index: 'roadTransportNum', width: 100},
        {title: '续航里程(新能源车)', index: 'enduranceMileage', width: 100},
        {title: '拼音', index: 'pinYin', width: 100},
        {title: '', index: 'remark', width: 100},
        {title: '车厢类型', index: 'carriageTypeId', width: 100},
        {title: '所属公司', index: 'companyId', width: 100},
        {title: '1:TMS 2:云调度 3:云驹宝', index: 'sysAppId', width: 100},
    {
      title: '操作',
     fixed: 'right',
      buttons: [
        {
          text: '修改',
          icon: 'edit',
          type: 'link',
          acl:'rmsVehicle.edit',
          click: (i: RmsVehicleGetPageModel) => this.editOnClick(i.id),
        },{
        text: '停用',
            iif: (item, btn, column) => (item.status === 1),
            acl:'rmsVehicle.disable',
            click: (i, modal, c) => {
            this.updateStatusClick(i,0);
        },
    },{
        text: '启用',
            iif: (item, btn, column) => (item.status !==1 ),
            acl:'rmsVehicle.enable',
            click: (i, modal, c) => {
            this.updateStatusClick(i,1);
        },
        },
      ],
      width: 100,
    },
  ];
  checkList: STData[] = [];
   searchSchema: SFSchema = {
       properties: {
           keyword: { type: 'string', title: '名称/编码' },
       },
   };
  constructor(
      private msg: NzMessageService,
      private rmsVehicleService: RmsVehicleService,
      private modal: ModalHelper,
  ) {}
 submit(value: any) {
    this.parameter=value;
    this.st.reset(1);
  }

   updateStatusClick(i:any,status:number){
       const request:RmsVehicleUpdateStatusRequest={};
       request.id=i.id;
       request.status=status;
       this.rmsVehicleService.updateStatus(request).then(res=>{
           if (res.code === 1) {
               this.msg.success('Success');
               this.st.load();
               i.status=status;
           } else {
               this.msg.error(res.message);
           }
       });
   }
  editOnClick(id?: any) {
    this.modal.create(RmsVehicleEditComponent, { id }, { size: 'lg' }).subscribe(() => this.st.load());
  }
  importClick() {
    this.modal.create(RmsVehicleImportComponent, {}, { size: 'lg' }).subscribe(() => this.st.load());
  }
  exportClick() {
    this.rmsVehicleService.exportExcel(this.getQueryParam());
  }
  change = (e: STChange) => {
    if (e.type === 'checkbox') {
      this.checkList = e.checkbox;
    } else if (e.type === 'pi') {
      if (e.pi === 1) {
        this.setTotal();
      }
      this.getPage(e.pi, e.ps);
    }
  };
  /**
   *查询当前页数据
   *
   * @param {*} pageIndex
   * @param {*} pageSize
   * @memberof UsersComponent
   */
  getPage(pageIndex, pageSize) {
    const request:RmsVehicleGetPageRequest = {queryParam:{},pageParam:{}};;
    request.pageParam.pageIndex = pageIndex;
    request.pageParam.pageSize = pageSize;
    request.queryParam= this.getQueryParam();
    this.rmsVehicleService.getPage(request).then(res => {
      this.data = res.data;
    });
    // aa
  }
  /**
   *设置总数量
   *
   * @memberof UsersComponent
   */
  setTotal() {
    const requestTotal:RmsVehicleGetTotalRequest = {queryParam:{}};
    requestTotal.queryParam = this.getQueryParam();
    this.rmsVehicleService.getTotal(requestTotal).then(res => {
      this.total = res.total;
    });
  }
 getQueryParam(){
    return {...this.parameter };
  }
}