import { Component, ViewChild } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd';
import { STColumn, STData, STChange, STComponent } from '@delon/abc';
import {  ModalHelper } from '@delon/theme';
import { ${table.entityName}Service } from './service/${table.name ? replace("_","-")}.service';
import { ${table.entityName}GetTotalRequest, ${table.entityName}GetPageModel, ${table.entityName}GetPageRequest,${table.entityName}UpdateStatusRequest } from './service/model/models';
import { ${table.entityName}EditComponent } from './edit/${table.name ? replace("_","-")}-edit.component';
import { ${table.entityName}ImportComponent } from './import/${table.name ? replace("_","-")}-import.component';
import { SFSchema } from '@delon/form';

@Component({
  selector: '${table.name ? replace("_","-")}',
  templateUrl: './${table.name ? replace("_","-")}.component.html',
  styleUrls: ['./${table.name ? replace("_","-")}.component.css'],
  // changeDetection: ChangeDetectionStrategy,
})
export class ${table.entityName}Component {
  @ViewChild(STComponent, { static: false })
  st: STComponent;
 formData: any={};
  parameter: any = {};
  currentSysOrgId = '';
  data: any[] = []; // 数据源
  total:any = 0;
  columns: STColumn[] = [
    <#list table.fields as f>
      <#if f.name == 'name'>
        { title: '${f.comment}', index: '${f.propertyName}', width: 140,fixed: 'left'},
      <#elseif f.name == 'status'>
        { title: '${f.comment}', index: '${f.propertyName}', width: 80, format:(item: STData, col: STColumn, index: number)=>{
          if(item.status===1){
              return "已启用";
          } else {
              return "已停用";
          }
        }},
      <#elseif f.name == 'create_time'>
        {title: '${f.comment}', index: '${f.propertyName}',type: 'date', width: 130},
      <#elseif f.name == 'update_time'>
        {title: '${f.comment}', index: '${f.propertyName}',type: 'date', width: 130},
      <#else>
        {title: '${f.comment}', index: '${f.propertyName}', width: 100},
      </#if>
    </#list>
    {
      title: '操作',
     fixed: 'right',
      buttons: [
        {
          text: '修改',
          icon: 'edit',
          type: 'link',
          acl:'${table.entityName ? uncap_first}.edit',
          click: (i: ${table.entityName}GetPageModel) => this.editOnClick(i.id),
        },{
        text: '停用',
            iif: (item, btn, column) => (item.status === 1),
            acl:'${table.entityName ? uncap_first}.disable',
            click: (i, modal, c) => {
            this.updateStatusClick(i,0);
        },
    },{
        text: '启用',
            iif: (item, btn, column) => (item.status !==1 ),
            acl:'${table.entityName ? uncap_first}.enable',
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
      private ${table.entityName ? uncap_first}Service: ${table.entityName}Service,
      private modal: ModalHelper,
  ) {}
 submit(value: any) {
    this.parameter=value;
    this.st.reset(1);
  }

   updateStatusClick(i:any,status:number){
       const request:${table.entityName}UpdateStatusRequest={};
       request.id=i.id;
       request.status=status;
       this.${table.entityName ? uncap_first}Service.updateStatus(request).then(res=>{
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
    this.modal.create(${table.entityName}EditComponent, { id }, { size: 'lg' }).subscribe(() => this.st.load());
  }
  importClick() {
    this.modal.create(${table.entityName}ImportComponent, {}, { size: 'lg' }).subscribe(() => this.st.load());
  }
  exportClick() {
    this.${table.entityName ? uncap_first}Service.exportExcel(this.getQueryParam());
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
    const request:${table.entityName}GetPageRequest = {queryParam:{},pageParam:{}};;
    request.pageParam.pageIndex = pageIndex;
    request.pageParam.pageSize = pageSize;
    request.queryParam= this.getQueryParam();
    this.${table.entityName ? uncap_first}Service.getPage(request).then(res => {
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
    const requestTotal:${table.entityName}GetTotalRequest = {queryParam:{}};
    requestTotal.queryParam = this.getQueryParam();
    this.${table.entityName ? uncap_first}Service.getTotal(requestTotal).then(res => {
      this.total = res.total;
    });
  }
 getQueryParam(){
    return {...this.parameter };
  }
}