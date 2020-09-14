<page-header-wrapper  [action]="action">
  <ng-template #action>
    <button (click)="editOnClick()" nz-button nzType="primary" id="btnAdd" acl="${table.entityName ? uncap_first}.add">新增</button>
    <button (click)="importClick()" nz-button nzType="primary" id="btnImport" acl="${table.entityName ? uncap_first}.import">导入</button>
    <button (click)="exportClick()" nz-button nzType="primary" acl="${table.entityName ? uncap_first}.export">导出</button>
  </ng-template>
   <sf #sf mode="search" [schema]="searchSchema" [(formData)]="formData" (formSubmit)="submit($event)"
  (formReset)="submit($event)"></sf>
  <st #st [data]="data" id="table${table.entityName}"      [scroll]="{x: '2000px'}"
      [total]="total" [columns]="columns" (change)="change($event)" noResult="您尚未创建任何记录"></st>
</page-header-wrapper>