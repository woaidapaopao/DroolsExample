package com.bigbubble.utils.JavaBeanDynamicCompile;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JavaBeanDynamicCompile implements IBeanDynamicCompile{

        ///
        ///编译
        public void compileJavaFileInDir(File sourceDir, String target) throws IOException {
            List<String> javaCode = getSourceFiles(sourceDir);
            IBeanDynamicCompile.compile(javaCode,target);
        }

        private List<String> getSourceFiles(File file) throws IOException {
            List<String> fileStringList = new ArrayList<>();
            if(file.exists()){
                if(!file.isDirectory()) {
                    if(file.getName().endsWith(".java")){
                        fileStringList.add(FileUtils.readFileToString(file, Charset.defaultCharset()));
                    }
                }
                else{
                    for(File path : Objects.requireNonNull(file.listFiles())){
                        fileStringList.addAll(getSourceFiles(path));
                    }
                }
            }
            return fileStringList;

        }
}
