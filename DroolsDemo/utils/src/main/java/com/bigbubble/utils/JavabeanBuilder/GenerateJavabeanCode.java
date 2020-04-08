package com.bigbubble.utils.JavabeanBuilder;

import com.bigbubble.utils.Model.ApplicationColumn;
import com.bigbubble.utils.Model.ApplicationConfigMapModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateJavabeanCode {
    public static void produce(ApplicationConfigMapModel configMapModel, String groupId, String targetPath) {
        StringBuilder javaBeanCode = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        javaBeanCode.append("package ").append(groupId).append(".").append(configMapModel.getAppId()).append(";")
                .append(lineSeparator).append("import java.io.Serializable;")
                .append(lineSeparator).append("public class ").append(configMapModel.getName())
                .append(lineSeparator).append("{").append(lineSeparator);
        boolean hasColumns = !configMapModel.getApplicationColumns().isEmpty();
        if(hasColumns){
            //声明变量
            for (ApplicationColumn column: configMapModel.getApplicationColumns()){
                String javaType = column.getType();
                String fieldName = column.getName();
                javaBeanCode.append("   private ").append(javaType).append(" ").append(fieldName).append(";").append(lineSeparator)
                        .append(lineSeparator);
            }
            //无参构造函数
            javaBeanCode.append("   public ").append(configMapModel.getName()).append("()").append(lineSeparator)
                    .append("{")
                    .append(lineSeparator)
                    .append("}")
                    .append(lineSeparator);
            //构造函数
            javaBeanCode.append("public ").append(configMapModel.getName()).append("(");
            for(ApplicationColumn column: configMapModel.getApplicationColumns()) {
                javaBeanCode.append(column.getType()).append(" ").append(column.getName());
            }
            javaBeanCode.append(")").append(lineSeparator)
                    .append("{")
                    .append(lineSeparator);
            for(ApplicationColumn column: configMapModel.getApplicationColumns()) {
                javaBeanCode.append("   this.").append(column.getName()).append("=").append(column.getName()).append(";").append(lineSeparator);
            }
            javaBeanCode.append("}");

            //get set方法
            for(ApplicationColumn column: configMapModel.getApplicationColumns()) {
                String javaType = column.getType();
                String fieldName = column.getName();
                javaBeanCode.append("   public ").append(javaType).append(" get").append(firstUpperCase(fieldName)).append("()").append(lineSeparator)
                        .append("   {").append(lineSeparator)
                        .append("       return ").append(fieldName).append(";").append(lineSeparator)
                        .append("   }").append(lineSeparator)
                        .append(lineSeparator);
                javaBeanCode.append("   public ").append(javaType).append(" set").append(firstUpperCase(fieldName)).append("()").append(lineSeparator)
                        .append("   {").append(lineSeparator)
                        .append("       return ").append(fieldName).append(";").append(lineSeparator)
                        .append("   }").append(lineSeparator)
                        .append(lineSeparator);
            }
            javaBeanCode.append("}");
            File file = new File(targetPath);
            if(!file.exists()){
                file.mkdirs();
            }
            try(FileWriter fileWriter = new FileWriter(targetPath+File.separator+configMapModel.getName()+".java")) {
                fileWriter.write(javaBeanCode.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private static String firstUpperCase(String str){
        if(str == null){
            return "";
        }
        if(str.length() == 1){
            return str.toUpperCase();
        }
        else {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }
}
