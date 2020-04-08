package com.bigbubble.utils.JavabeanBuilder;

import com.alibaba.fastjson.JSON;
import com.bigbubble.utils.Model.ApplicationConfigMapModel;
import com.bigbubble.utils.Model.ApplicationColumn;
import com.bigbubble.utils.Model.IConfigMapModel;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;


public class JavaBeanBuilderFromResource implements IJavaBeanBuilder<ApplicationConfigMapModel> {
    @Override
    public ApplicationConfigMapModel getConfigMapModel() {
        try {
            InputStream inputStream = JavaBeanBuilderFromResource.class.getClassLoader().getResourceAsStream("config.json");
            String text = IOUtils.toString(inputStream,"utf-8");
            return JSON.parseObject(text, ApplicationConfigMapModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ApplicationConfigMapModel();
    }


}
