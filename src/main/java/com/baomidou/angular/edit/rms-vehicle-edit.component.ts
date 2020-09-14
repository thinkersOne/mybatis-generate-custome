import { Component, ChangeDetectionStrategy, OnInit } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { RmsVehicleService } from '../service/rms-vehicle.service';
import { RmsVehicleSaveModel,RmsVehicleSaveRequest } from '../service/model/models';
import { AbstractControl } from '@angular/forms';
import { SEComponent } from '@delon/abc';
import {E8HttpClient} from "@core";
@Component({
  selector: 'rms-vehicle-edit',
  templateUrl: './rms-vehicle-edit.component.html',
})
export class RmsVehicleEditComponent implements OnInit {
  model: RmsVehicleSaveModel = {};
  id: string;
  constructor(
    private msg: NzMessageService,
    private modal: NzModalRef,
    private rmsVehicleService: RmsVehicleService,private http:E8HttpClient,
  ) { }

  ngOnInit() {
    if (this.id !== undefined) {
      this.rmsVehicleService.getModel({ id: this.id }).then(res => {
        this.model = res.data;
      })
    }
  }

  saveOnClick() {
    const request:RmsVehicleSaveRequest ={};
    request.model = this.model;
    this.rmsVehicleService.save(request).then(res => {
      if (res.code === 1) {
        this.msg.success('Success');
        this.modal.close(res);
      } else {
        this.msg.error(res.message);
      }
    });
  }

  notExistsName = (ctrl: AbstractControl, se: SEComponent) => {
    return this.rmsVehicleService.existsName({ id: this.model.id, name: ctrl.value }).then(t => {
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
    return this.rmsVehicleService.existsCode({ id: this.model.id, code: ctrl.value }).then(t => {
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