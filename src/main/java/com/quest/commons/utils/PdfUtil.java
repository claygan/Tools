package com.quest.commons.utils;

import com.quest.commons.ServiceFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import static com.quest.commons.ServiceFactory.getBean;

/**
 * Created by Quest on 2017/7/25.
 */
public class PdfUtil {
    public static Boolean generatePdf(String tempHtml, String outputFile) {
//        String cmd = "\\plugins\\wkhtmltopdf\\bin\\wkhtmltoimage";
        Properties config = ServiceFactory.getBean("config", Properties.class);
        String cmd = config.getProperty("pdf.cmd");
        String path = new File(cmd).getAbsolutePath();
        try {
            CmdUtil.exec(true, path+cmd, tempHtml, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
