/**
 * Xforce+ athena API
 * Xforce+ athena API 3.0
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

/**
 * null
 */
export interface ${table.entityName}GetPageModel {
    <#list table.fields as f>
      <#if f.type == 'int'>
       /**
        * ${f.comment}
       */
       ${f.propertyName}?: number;
      <#else>
      /**
       * ${f.comment}
      */
      ${f.propertyName}?: string;
      </#if>
    </#list>

}