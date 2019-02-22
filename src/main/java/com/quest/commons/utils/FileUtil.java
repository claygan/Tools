package com.quest.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;

/**
 * Created by Quest on 2018/8/19.
 */
public class FileUtil {
    public static String readContent(Path path){
        File file = path.toFile();
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try (FileInputStream in = new FileInputStream(file)){
            in.read(filecontent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
