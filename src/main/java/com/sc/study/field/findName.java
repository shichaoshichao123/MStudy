package com.sc.study.field;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-18 15:50
 * @desc
 */
public class findName {

    /**
     * 获取对象中的指定属性值
     *
     * @param targetObject
     * @param name
     * @return
     */
    private String getValueByReflection(Object targetObject, String name) {
        if (null == targetObject || StringUtils.isEmpty(name) || isPrimitive(targetObject)) {
            return null;

        }
        Field[] fields = targetObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            String result = null;
            try {
                field.setAccessible(true);
                if (field.getName().equals(name)) {
                    if (field.get(targetObject) != null) {
                        result = field.get(targetObject).toString();
                    }

                } else if (!isPrimitive(field.get(targetObject))) {
                    //不是基础类型继续递归寻找
                    result =  getValueByReflection(field.get(targetObject), name);

                }
            } catch (IllegalAccessException e) {

            }
            if (null != result) {
                return result;
            }

        }
        return null;
    }

    /**
     * 判断一个对象是否是基本类型或基本类型的封装类型
     * 注意：这里加一下String类型
     */
    private static boolean isPrimitive(Object obj) {
        try {
            if (obj instanceof String) {
                return true;
            }
            return ((Class<?>) obj.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        findName findName = new findName();
        Student student = new Student(11, "应琪");
        Table table = new Table(1, "应琪的Table");
        ClassRoom classRoom = new ClassRoom(1, "11班", student, table);
        System.out.println(findName.getValueByReflection(classRoom, "classroomIqqd"));
        System.out.println(findName.getValueByReflection(classRoom, "studentName"));
        System.out.println(findName.getValueByReflection(classRoom, "tableName"));
    }
}
