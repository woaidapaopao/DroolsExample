package com.bigbubble.utils.JavabeanBuilder;

import com.bigbubble.utils.Model.IConfigMapModel;

/*
用于进行配置文件获取并生成.java文件
 */
public interface IJavaBeanBuilder<T extends IConfigMapModel> {

    public T getConfigMapModel();

    public void generateJavabeanCode(T configMapModel,String targetPath);


}
