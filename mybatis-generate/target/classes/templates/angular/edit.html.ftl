<div class="modal-header">
  <div class="modal-title">{{ model.id != null ? '编辑' : '添加' }}</div>
</div>
<form nz-form #f="ngForm" (ngSubmit)="saveOnClick()">
  <div se-container="2">
     <#list table.fields as f>
     <#if f.name == 'name'>
        <se label="${f.comment}" [id]="'txt${f.propertyName ? cap_first}'" #se${f.propertyName ? cap_first} error="不能为空" required>
            <input nz-input [(ngModel)]="model.${f.propertyName}" [c8SeError]="se${f.propertyName ? cap_first}"
                id="txt${f.propertyName ? cap_first}" [c8Validator]="notExistsName"
                   name="${f.propertyName}" required />
        </se>
     <#elseif f.name == 'code'>
        <se label="${f.comment}" [id]="'txt${f.propertyName ? cap_first}'" #se${f.propertyName ? cap_first} error="不能为空" required>
            <input nz-input [(ngModel)]="model.${f.propertyName}" [c8SeError]="se${f.propertyName ? cap_first}"
                id="txt${f.propertyName ? cap_first}" [c8Validator]="notExistsName"
                   name="${f.propertyName}" required />
        </se>
     <#elseif f.name == 'remark'>
        <se label="${f.comment}" [id]="'txt${f.propertyName ? cap_first}'" #se${f.propertyName ? cap_first}>
            <input nz-input [(ngModel)]="model.${f.propertyName}"
                id="txt${f.propertyName ? cap_first}"
                   name="${f.propertyName}" />
        </se>
     <#else>
        <se label="${f.comment}" [id]="'txt${f.propertyName ? cap_first}'" #se${f.propertyName ? cap_first}>
            <input nz-input [(ngModel)]="model.${f.propertyName}"
                id="txt${f.propertyName ? cap_first}" name="${f.propertyName}" />
        </se>
     </#if>
     </#list>
  </div>
  <div class="modal-footer">
    <button nz-button type="button" (click)="closeOnClick()" id="btnClose">关闭</button>
    <button nz-button nzType="primary" [disabled]="f.invalid" id="btnSave" [nzLoading]="http.loading">
      保存
    </button>
  </div>
</form>
