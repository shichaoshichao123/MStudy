package com.sc.study.jvm;

import java.io.*;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-23 22:05
 * @desc
 */
public class MyClassLoader extends ClassLoader {

    private String classLoadName = "";

    /**
     * 文件后缀
     */
    private static final String fileTail = ".class";


    public MyClassLoader(String classLoadName) {
        //调用这个的作用是以系统类加载器为父加载器生产一个新的类加载器，所以返回的其实也是应用类加载器
        super();
        this.classLoadName = classLoadName;
    }

    public MyClassLoader(ClassLoader parent, String classLoadName) {
        //指定特殊类型的类加载器作为本类加载的父加载器
        super(parent);
        this.classLoadName = classLoadName;
    }

    @Override
    public String toString() {
        return "MyClassLoader{" +
                "classLoadName='" + classLoadName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] data = new byte[0];
        try {
            data = loadClassData(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == data) {
            System.out.println("加载类的二进制文件失败");
            return null;

        }
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 用于加载指定类的二进制数组
     *
     * @return
     * @throws Exception
     */
    private byte[] loadClassData(String fileName) throws Exception {
        InputStream in = null;
        byte[] data = null;
        ByteArrayOutputStream bos = null;

        try {
            fileName = fileName.replace(".", "/");
            in = new FileInputStream(new File("/Users/zdwh/Desktop/"+fileName + fileTail));
            bos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = in.read()) != -1) {
                bos.write(ch);
            }
            data = bos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        loadTest(new MyClassLoader("TestClassLoader"),"com.sc.study.jvm.TestClass");
    }

    /**
     * 测试加载
     *
     * @param classLoader
     * @param path
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void loadTest(ClassLoader classLoader, String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass(path);
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println(clazz.getClassLoader());
        System.out.println(object.getClass());
        System.out.println(object.getClass().getClassLoader());
        System.out.println(object.getClass().getClassLoader().getParent());

    }
}
