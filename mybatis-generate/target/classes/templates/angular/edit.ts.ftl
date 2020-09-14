import { Component, ChangeDetectionStrategy, OnInit } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { ${table.entityName}Service } from '../service/${table.name ? replace("_","-")}.service';
import { ${table.entityName}SaveModel,${table.entityName}SaveRequest } from '../service/model/models';
import { AbstractControl } from '@angular/forms';
import { SEComponent } from '@delon/abc';
import {E8HttpClient} from "@core";
@Component({
  selector: '${table.name ? replace("_","-")}-edit',
  templateUrl: './${table.name ? replace("_","-")}-edit.component.html',
})
export class ${table.entityName}EditComponent implements OnInit {
  model: ${table.entityName}SaveModel = {};
  id: string;
  constructor(
    private msg: NzMessageService,
    private modal: NzModalRef,
    private ${table.entityName ? uncap_first}Service: ${table.entityName}Service,private http:E8HttpClient,
  ) { }

  ngOnInit() {
    if (this.id !== undefined) {
      this.${table.entityName ? uncap_first}Service.getModel({ id: this.id }).then(res => {
        this.model = res.data;
      })
    }
  }

  saveOnClick() {
    const request:${table.entityName}SaveRequest ={};
    request.model = this.model;
    this.${table.entityName ? uncap_first}Service.save(request).then(res => {
      if (res.code === 1) {
        this.msg.success('Success');
        this.modal.close(res);
      } else {
        this.msg.error(res.message);
      }
    });
  }

  notExistsName = (ctrl: AbstractControl, se: SEComponent) => {
    return this.${table.entityName ? uncap_first}Service.existsName({ id: this.model.id, name: ctrl.value }).then(t => {
      if (t.data) {
        se.error = '名称已存在';
        return { nameExists: !t.data }
      } else {
        se.error = "不能为空";
        return null;
      }
    }).catch(() => null);
  }
  notExistsCode = (ctrl: AbstractControl, se: SEComponent) => {
    return this.${table.entityName ? uncap_first}Service.existsCode({ id: this.model.id, code: ctrl.value }).then(t => {
      if (t.data) {
        se.error = '编码已存在';
        return { nameExists: !t.data }
      } else {
        se.error = "不能为空";
        return null;
      }
    }).catch(() => null);
  }


  closeOnClick() {
    this.modal.close();
  }
}