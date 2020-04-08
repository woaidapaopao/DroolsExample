package com.bigbubble.utils;

import com.bigbubble.utils.JavabeanBuilder.JavaBeanBuilderFromResource;
import com.bigbubble.utils.Model.ApplicationConfigMapModel;
import org.junit.Test;


public class UtilsApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println( "abc");
    }

    @Test
    public void TestJsonTools(){

        JavaBeanBuilderFromResource javaBeanBuilderFromResource = new JavaBeanBuilderFromResource();
        ApplicationConfigMapModel configMapModel = javaBeanBuilderFromResource.getConfigMapModel();
        configMapModel.getApplicationColumns().forEach(System.out::println);
    }
}
