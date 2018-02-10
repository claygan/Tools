package com.quest.test;

import com.quest.commons.utils.Base64Util;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;


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

    @Test
    public void test2() throws MalformedURLException {
        File file = new File("F:\\Desktop\\MdcApiImpl.class");

        System.out.println(file.toURI());
        System.out.println(file.toURI().toURL());
        ClassLoader parent = Thread.currentThread().getContextClassLoader();
        List<URL> urls = new ArrayList<>();
        urls.add(file.toURI().toURL());
        URLClassLoader ucl = new URLClassLoader(urls.toArray(new URL[urls.size()]), parent);
        System.out.println(ucl);
    }
}
