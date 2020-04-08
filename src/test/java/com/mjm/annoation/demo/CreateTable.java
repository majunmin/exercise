package com.mjm.annoation.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 15:43
 * @since
 */
public class CreateTable {

    public static void main(String[] args) {
        try {
            System.out.println(createTableSql("com.mjm.annoation.demo.Member"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        /**
         * StringBuffer String字符串拼接 效率问题
         */
        Instant start = Instant.now();
        String tmp1 = "abc" + "cde" + "fgh";
        System.out.println(tmp1);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toNanos());

        start = Instant.now();
        String tmp2 = new StringBuffer("abc").append("cde").append("efg").toString();
        System.out.println(tmp2);
        end = Instant.now();
        System.out.println(Duration.between(start, end).toNanos());

        String s1 = "abc";
        String s2 = "def";
        String s3 = "ghi";
        start = Instant.now();
        String tmp3 = s1 + s2 + s3;
        System.out.println(tmp3);
        end = Instant.now();
        System.out.println(Duration.between(start, end).toNanos());
    }

    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("No DBTable annoation in class: " + className);
            return null;
        }

        String tableName = dbTable.name();
        if (tableName.length() < 1) {
            tableName = clazz.getName().toUpperCase();
        }

        List<String> columnDefs = new ArrayList<String>();
        for (Field field : clazz.getDeclaredFields()) {
            String columnName = null;
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length < 1)
                continue;
            if (annotations[0] instanceof SqlInteger) {
                SqlInteger sInteger = (SqlInteger) annotations[0];
                if (sInteger.name().length() < 1)
                    columnName = field.getName().toUpperCase();
                else
                    columnName = sInteger.name();

                columnDefs.add(columnName + " INT" + getConstraints(sInteger.constraint()));
            }

            if (annotations[0] instanceof SqlString) {
                SqlString sString = (SqlString) annotations[0];
                if (sString.name().length() < 1)
                    columnName = field.getName().toUpperCase();
                else
                    columnName = sString.name();

                columnDefs.add(columnName + " VARCHAR(" + sString.value()+ ")" + getConstraints(sString.constraint()));
            }
        }

        return buildCreateTableSql(tableName, columnDefs);
    }


    /**
     * 获取 约束条件
     * @param con
     * @return
     */
    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY KEY";
        if (con.unique())
            constraints += " UNIQUE";
        return constraints;
    }

    public static String buildCreateTableSql(String tableName, List<String> columnDefs){
        //数据库表构建语句
        StringBuilder createCommand = new StringBuilder();
        createCommand.append("CREATE TABLE " + tableName + "(");
        for(String columnDef : columnDefs)
            createCommand.append("\n    " + columnDef + ",");

        // Remove trailing comma
        String tableCreate = createCommand.substring(0, createCommand.length() - 1) + "\n);";
        return tableCreate;
    }
}
