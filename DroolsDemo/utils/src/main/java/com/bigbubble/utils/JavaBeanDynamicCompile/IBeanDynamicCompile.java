package com.bigbubble.utils.JavaBeanDynamicCompile;

import com.bigbubble.utils.Model.IConfigMapModel;
import org.omg.CORBA.ExceptionList;

import javax.tools.*;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

//
public interface IBeanDynamicCompile {


    /*
    编译java代码生成class
     */
    static boolean compile(List<String> sourceJavaFileList,String targetDir){
        if(sourceJavaFileList.size()<1){
            return false;
        }
        DiagnosticCollector<JavaFileObject> diagnosticCollector = new DiagnosticCollector<>();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticCollector,null,null);
        Iterable<? extends JavaFileObject> javaFileObjects = fileManager.getJavaFileObjects(sourceJavaFileList.toArray(new String[0]));
        File outputFolder = new File(targetDir);
        if(!outputFolder.exists()){
            boolean mkdir = outputFolder.mkdir();
        }
        Iterable<String> options = Arrays.asList( "-d", outputFolder.getAbsolutePath() , "-g", "-proc:none");
        final StringWriter output = new StringWriter();
        JavaCompiler.CompilationTask task = compiler.getTask(output,fileManager,diagnosticCollector,options,null,javaFileObjects);
        boolean result = task.call();
        if (!result) {
            throw new IllegalArgumentException(
                    "Compilation failed:\n" + output);
        }
        List list = diagnosticCollector.getDiagnostics();
        for (Object object : list) {
            Diagnostic d = (Diagnostic) object;
            System.out.println(d.getMessage(Locale.ENGLISH));
        }
        return true;
    };
}
