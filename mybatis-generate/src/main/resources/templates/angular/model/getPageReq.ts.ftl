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
 */import { PageParam } from './pageParam';
import { ${table.entityName}GetPageParam } from './${table.entityName ? uncap_first}GetPageParam';


/**
 * null
 */
export interface ${table.entityName}GetPageRequest {
    pageParam?: PageParam;
    queryParam?: ${table.entityName}GetPageParam;
}