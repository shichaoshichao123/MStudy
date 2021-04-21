package com.sc.study.field;

import lombok.Data;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-18 15:51
 * @desc
 */
@Data
public class Student {
    private Integer studentId;
    private String studentName;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
