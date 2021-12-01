package com.sc.study.field;

import lombok.Data;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-18 15:51
 * @desc
 */
@Data
public class Table {
    private Integer tableId;
    private String tableName;

    public Table(Integer tableId, String tableName) {
        this.tableId = tableId;
        this.tableName = tableName;
    }
}
