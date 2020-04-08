package com.bigbubble.droolsdemo.web.controller;
import com.bigbubble.utils.JavabeanBuilder.JavaBeanBuilderFromResource;
import com.bigbubble.utils.JavabeanBuilder.GenerateJavabeanCode;
import com.bigbubble.utils.Model.ApplicationConfigMapModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeGeneraterController {
    @RequestMapping(value = "/helloWord", method = RequestMethod.GET)
    public String helloWord(){
        return "Hello";
    }
    @GetMapping(value = "/CreateJavabeanFromResource")
    public String createJavaBeanFromResource(){
        JavaBeanBuilderFromResource javaBeanBuilderFromResource = new JavaBeanBuilderFromResource();
        ApplicationConfigMapModel configMapModel = javaBeanBuilderFromResource.getConfigMapModel();
        String groupid = "test";
        GenerateJavabeanCode.produce(configMapModel,groupid,"../com/bigbubble/test");
        return "Hello";
    }
}
