package com.quest.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Base64Util {
    /**
     * 日志
     */
    private static Log  logger = LogFactory.getLog(Base64Util.class);
    /**
     * 将文件转成base64 字符串
     * @param file 文件
     * @return encodedFileString
     * @throws Exception
     */

    public static String getFileByteString(File file) throws Exception {
        FileInputStream inputFile = new FileInputStream(file);
        // 取得文件大小
        long length = file.length();
        // 根据大小创建字节数组
        byte[] buffer = new byte[(int) length];

        inputFile.read(buffer);
        inputFile.close();
        //base64转码 new String((new Base64()).encode(buffer))
        String encodedFileString = Base64.encodeBase64String(buffer);
        return encodedFileString;
    }
    /**
     * 将base64字符解码保存文件
     * @param base64Code  解码
     * @param targetPath 要存的地址
     * @return
     */

    public static String decoderBase64File(String base64Code, String targetPath) {
        File file = new File(targetPath);
        try {
            if (file.exists()) {
                logger.error(targetPath + " 文件已经存在，不能转换为文件");
                return null;
            } else {
                boolean createNewFile = file.createNewFile();
                if (createNewFile) {
                    logger.info("文件创建成功！");
                } else {
                    logger.info("文件创建遇到问题。");
                }
            }
            byte[] buffer = new Base64().decode(base64Code);
            FileOutputStream out = new FileOutputStream(targetPath);
            out.write(buffer);
            out.close();
            logger.info("文件保存成功！");
        } catch (Exception e) {
            logger.error("文件base64编码转换失败！",e);
            targetPath = "";
        }

        return targetPath;
    }
    /**
     * 将字符串转换成Base64编码
     * @param tagertStr 要转换的字符串
     * @return
     */
    public static String convert(String tagertStr) {
        byte[] value;
        try {
            value = tagertStr.getBytes(Charsets.UTF_8);
            return new String(Base64.encodeBase64(value),Charsets.UTF_8);
        } catch (Exception e) {
            logger.error("字符串base64编码转换失败！" + e);
        }
        return null;
    }

}
