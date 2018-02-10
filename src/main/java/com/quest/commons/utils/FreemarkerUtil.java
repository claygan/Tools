package com.quest.commons.utils;

import com.quest.entity.User;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * Created by Quest on 2017/12/28.
 */
public class FreemarkerUtil {
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static void generateFile(String tempPath, String outPath, String name, Map<String, Object> context) {
        try {
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            configuration.setTemplateLoader(new ClassTemplateLoader());
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            File fileDir = new File(outPath);
            if (!fileDir.isDirectory()) {
                fileDir.mkdirs();
            }
            generateOut(fileDir+"/"+name, tempPath, configuration, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateOut(String pathname, String templateName,
                                    Configuration configuration, Map<String, Object> context) throws Exception {
        FileOutputStream fos = new FileOutputStream(pathname);
        OutputStreamWriter osw = new OutputStreamWriter(fos, DEFAULT_CHARSET);
        BufferedWriter out = new BufferedWriter(osw);
        Template template = configuration.getTemplate(templateName);
        template.process(context, out);
        out.close();
    }
}
