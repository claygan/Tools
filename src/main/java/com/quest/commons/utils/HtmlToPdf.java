package com.quest.commons.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class HtmlToPdf {

    /**
     * 生成16位字符串，规则：13位时间戳 + 3位字母数字随机串(36进制随机数)
     */
    public static String generateSixteen() {
        Date d = new Date();
        String time = String.valueOf(d.getTime());
        Random rand = new Random();
        int num = rand.nextInt(46654);
        String str = Integer.toString(num, 36);
        return time + str;
    }
    
    /**
     * html转pdf
     * @param srcPath html路径，可以是硬盘上的路径，也可以是网络路径
     * @param destPath pdf保存路径
     * @return 转换成功返回true
     */
    public static boolean convert(String srcPath, String destPath, String ym, String yj) {
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if (!parent.exists()) {
            parent.mkdirs();
        }

        StringBuilder cmd = new StringBuilder();
        cmd.append("/home/wkhtmltopdf").append("  ");

        cmd.append("  --header-html  ").append(ym);//页眉
        cmd.append("  --header-spacing 5   ");//页眉与正文之间的距离

        cmd.append("  --footer-html  ").append(yj);//页脚
        cmd.append("  --footer-spacing 5   ");//页脚与正文之间的距离

        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);

        boolean result = true;
        try {
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
            error.start();
            output.start();
            proc.waitFor();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            new File(ym).delete();
            new File(yj).delete();
        }
        return result;
    }

    // 页眉
    public static String generateYm(Map variables) throws Exception {
        String htmlPath = null;// 生成html路径
        OutputStream output = null;
        try {
            String htmlContent = generate("htmltopdf/pageTop.html", variables);
            String outputFileClass = ResourceLoader.getPath("");// classpath 路径

            htmlPath = new File(outputFileClass).getAbsolutePath()
                    + "/htmltopdf/" + generateUUID() + ".html";

            byte[] data = htmlContent.getBytes("UTF-8");
            File htmlFile = new File(htmlPath);
            if (!htmlFile.exists()) {
                htmlFile.createNewFile();
            } else {
                htmlFile.delete();
                htmlFile.createNewFile();
            }
            output = new FileOutputStream(htmlFile);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(data);
            bufferedOutput.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(output);
        }
        return htmlPath;
    }

    // 页脚
    public static String generateYj(Map variables) throws Exception {
        String htmlPath = null;// 生成html路径
        OutputStream output = null;
        try {
            String htmlContent = generate("htmltopdf/pageBottom.html", variables);
            String outputFileClass = ResourceLoader.getPath("");// classpath 路径

            htmlPath = new File(outputFileClass).getAbsolutePath()
                    + "/htmltopdf/" + generateUUID() + ".html";

            byte[] data = htmlContent.getBytes("UTF-8");
            File htmlFile = new File(htmlPath);
            if (!htmlFile.exists()) {
                htmlFile.createNewFile();
            } else {
                htmlFile.delete();
                htmlFile.createNewFile();
            }
            output = new FileOutputStream(htmlFile);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(data);
            bufferedOutput.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(output);
        }
        return htmlPath;
    }

    // 内容正文
    public static boolean generate(String template, Map variables,
                            String outputFile) throws Exception {
        boolean result = true;
        File htmlFile = null;
        OutputStream output = null;
        try {
            String htmlContent = generate(template, variables);
            // classpath 路径
            String outputFileClass = ResourceLoader.getPath("");

            // 生成html路径
            String htmlPath = new File(outputFileClass).getAbsolutePath()
                    + "/htmltopdf/" + generateUUID() + ".html";

            byte[] data = htmlContent.getBytes("UTF-8");
            htmlFile = new File(htmlPath);
            if (!htmlFile.exists()) {
                htmlFile.createNewFile();
            } else {
                htmlFile.delete();
                htmlFile.createNewFile();
            }
            output = new FileOutputStream(htmlFile);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(data);
            bufferedOutput.flush();

            String ym = generateYm(variables);
            String yj = generateYj(variables);

            result = convert(htmlPath, outputFile, ym, yj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(output);
            htmlFile.delete();
        }
        return result;
    }

    /**
     * 关闭指定的OutputStream
     * @param outs 输出流可变参数
     */
    public static void close(OutputStream... outs) {
        if (outs != null && outs.length > 0) {
            for (OutputStream out : outs) {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace(System.err);
                    }
                    out = null;
                }
            }
        }
    }

    /**
     * 将随机生成的UUID字符串"-"替换为""后输出
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generate(String template, Map<String, Object> variables)
            throws IOException, TemplateException {
        BufferedWriter writer = null;
        String htmlContent = "";
        try {
            Configuration config = FreemarkerConfiguration.getConfiguation();
            config.setDefaultEncoding("UTF-8");
            Template tp = config.getTemplate(template);
            StringWriter stringWriter = new StringWriter();
            writer = new BufferedWriter(stringWriter);

            tp.setEncoding("UTF-8");
            tp.process(variables, writer);
            htmlContent = stringWriter.toString();
            writer.flush();
        } finally {
            if (writer != null)
                writer.close();
        }
        return htmlContent;
    }

}
