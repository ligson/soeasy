package org.ligson.soeasy.utils;

import org.ligson.codegenerator.orm.template.utils.TemplateEngine;

import java.io.File;

public class Test {


    public static void rename(File root) {
        for(File file:root.listFiles()){
            if (file.isDirectory()) {
                rename(file);
            } else {
                File file2 = new File(file.getParent(), file.getName() + ".java");
                file.renameTo(file2);
            }
        }
    }

    public static void main(String[] args) {
        //File file = new File("F:\\workspace\\soeasy\\src\\main\\groovy\\org\\ligson");
        //rename(file);
        File file = new File("F:\\workspace\\soeasy\\src\\main\\resources\\META-INF\\mybatis\\mapper\\test.xml");
        System.out.println(file.exists());
        String code = TemplateEngine.getUserCustomCode(file);
        System.out.println(code);
    }
}


