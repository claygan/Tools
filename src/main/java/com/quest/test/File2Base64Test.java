package com.quest.test;

import com.quest.commons.utils.Base64Util;
import org.junit.Test;

import java.io.File;



/**
 * Created by Quest on 2017/9/15.
 */
public class File2Base64Test {
    @Test
    public void test() throws Exception {
        File file = new File("F:\\Desktop\\a.jpg");
        String encodedFileString = Base64Util.getFileByteString(file);
        System.out.println("---------------------------------------------------");
        System.out.println(encodedFileString);
        System.out.println("---------------------------------------------------");

        String targetPath = Base64Util.decoderBase64File(encodedFileString, "F:\\Desktop\\b.jpg");
        System.out.println("targetPath: "+targetPath);
    }
}
