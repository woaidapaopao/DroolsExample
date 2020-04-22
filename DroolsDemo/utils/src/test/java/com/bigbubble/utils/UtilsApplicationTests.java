package com.bigbubble.utils;

import com.bigbubble.utils.JavabeanBuilder.GenerateJavabeanCode;
import com.bigbubble.utils.JavabeanBuilder.JavaBeanBuilderFromResource;
import com.bigbubble.utils.Model.ApplicationConfigMapModel;
import org.junit.Test;


public class UtilsApplicationTests {

    @Test
    public void contextLoads() {
        String currentclasspath = UtilsApplicationTests.class.getResource("/").getPath();
        JavaBeanBuilderFromResource javaBeanBuilderFromResource = new JavaBeanBuilderFromResource();
        ApplicationConfigMapModel configMapModel = javaBeanBuilderFromResource.getConfigMapModel();
        GenerateJavabeanCode.produce(configMapModel,"dapaopao",currentclasspath+"dapaopao/");
    }

    @Test
    public void TestJsonTools(){

        JavaBeanBuilderFromResource javaBeanBuilderFromResource = new JavaBeanBuilderFromResource();
        ApplicationConfigMapModel configMapModel = javaBeanBuilderFromResource.getConfigMapModel();
        configMapModel.getApplicationColumns().forEach(System.out::println);
        System.out.println(UtilsApplicationTests.class.getResource("/").getPath());
    }
}
