package com.quest.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.PostVMInitHook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by Quest on 2017/7/25.
 */
public class ProcessTest {
    private static Logger log = LoggerFactory.getLogger(ProcessTest.class);

    public static void main(String[] args) {
        try {
            String cmd = "D:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf http://localhost:8002/export/pdfHtml F:\\9d16fbdfa8454535bb454616c5912eb6.pdf";
            readConsole(cmd, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readConsole(String cmd, Boolean isPrettify) throws IOException {
        StringBuffer cmdout = new StringBuffer();
        log.info("执行命令：" + cmd);
        Process process = Runtime.getRuntime().exec(cmd);     //执行一个系统命令
        InputStream fis = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"GB2312"));//windows环境下默认GBK/GB2312
        String line = null;
        if (isPrettify == null || isPrettify) {
            while ((line = br.readLine()) != null) {
                cmdout.append(line);
            }
        } else {
            while ((line = br.readLine()) != null) {
                cmdout.append(line).append(System.getProperty("line.separator"));
            }
        }
        log.info("执行系统命令后的结果为：\n" + cmdout.toString());
        return cmdout.toString().trim();
    }
}
