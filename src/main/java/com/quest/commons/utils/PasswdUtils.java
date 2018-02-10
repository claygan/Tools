package com.quest.commons.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource.Util;
/**
 * Created by Quest on 2017/12/26.
 */
public class PasswdUtils {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorithmName = "SHA-512";
    private static int hashIterations = 3;

    public PasswdUtils() {
    }

    public static String encryptPassword(String password, String salt) {
        String encryptPassword = (new SimpleHash(algorithmName, password, Util.bytes(salt), hashIterations)).toBase64();
        return encryptPassword;
    }

    public static void main(String[] args) {
        String username = "zshc";
        System.out.println(username);
        System.out.println(encryptPassword("jkjc_123456",username));
    }
}
