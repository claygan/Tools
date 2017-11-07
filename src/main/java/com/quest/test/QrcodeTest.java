package com.quest.test;

import com.quest.commons.utils.QRCoderUtil;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Quest on 2017/9/26.
 */
public class QrcodeTest {
    /**
     *@Description: swetake
     */
    @Test
    public void qrcodeTest(){
        try {
            BufferedImage image = QRCoderUtil.createQRCode("http://www.baidu.com","jpg" , 10);
            ImageIO.write(image,"jpg",new File("F:\\Desktop\\a.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
