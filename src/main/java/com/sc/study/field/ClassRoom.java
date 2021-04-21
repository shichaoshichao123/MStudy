package com.sc.study.field;

import lombok.Data;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-18 15:51
 * @desc
 */
@Data
public class ClassRoom {
    private Integer classroomId;
    private String classroomName;
    private Student student;
    private Table table;

    public ClassRoom(Integer classroomId, String classroomName, Student student, Table table) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.student = student;
        this.table = table;
    }

}
