package com.quest.test;

import com.sun.xml.internal.fastinfoset.stax.events.XMLConstants;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Quest on 2017/12/22.
 */
public class RealPathTest {
    @Test
    public void original() throws IOException {
        String relativelyPath=System.getProperty("user.dir");
        System.out.println(relativelyPath);
        //
        Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(t);
        //
        URL url = XMLConstants.class.getResource("/");
        System.out.println(url.getPath());
        //
        File file = new File(this.getClass().getResource("/").getFile());
        System.out.println(file.getCanonicalPath());
    }
}
