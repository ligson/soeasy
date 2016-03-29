package org.ligson.cg.orm.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

/**
 * Created by ligson on 2016/2/22.
 */
public class TemplateEngine {
    private static Configuration cfg = new Configuration(Configuration.getVersion());

    static {
        // 指定FreeMarker模板文件的位置
        String ftlPath = TemplateEngine.class.getClassLoader().getResource("./cgconf/ftl").getFile();
        File ftlRootDir = new File(ftlPath);
        try {
            cfg.setDirectoryForTemplateLoading(ftlRootDir);
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.getVersion()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getUserCustomCode(File destFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(destFile));
            StringBuilder builder = new StringBuilder();
            String line = null;
            boolean start = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<!--用户自定义代码开始-->")) {
                    start = true;
                    continue;
                }
                if (line.contains("<!--用户自定义代码结束-->")) {
                    start = false;
                }
                if (start) {
                    builder.append(line).append("\n\r");
                }
            }
            if (builder.length() > 2) {
                builder.delete(builder.length() - 2, builder.length());
            }
            reader.close();
            if (builder.toString().equals("\n\r")) {
                return null;
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(String templateName, Map<String, Object> varMap, File destFile) {
        String code = null;
        if (destFile.exists()) {
            code = getUserCustomCode(destFile);
        } else {
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (code == null) {
            code = "";
        }
        varMap.put("userCustomCode", code);
        try {
            Template temp = cfg.getTemplate(templateName, "UTF-8");
            temp.process(varMap, new FileWriter(destFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
