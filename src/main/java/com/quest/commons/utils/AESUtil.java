package com.quest.commons.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * Created by Quest on 2018/4/25.
 */
public class AESUtil {
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";
    /**
     * 生成key
     */
    private static final String key = "JianKangShengMingHai201803121592";//此处为测试key，正式环境请替换成商户密钥
    private static SecretKeySpec secretKey = new SecretKeySpec(MD5Util.MD5Encode(key, "UTF-8").toLowerCase().getBytes(), ALGORITHM);

    /**
     * AES加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptData(String data) throws Exception {
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64Util2.encode(cipher.doFinal(data.getBytes()));
    }

    /**
     * AES解密
     *
     * @param base64Data
     * @return
     * @throws Exception
     */
    public static String decryptData(String base64Data) throws Exception {
        //通过BouncyCastle组件来让java里面支持PKCS7Padding填充
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        // 初始化
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64Util2.decode(base64Data)));
    }

    public static void main(String[] args) throws Exception {
        //String A 为测试字符串，是微信返回过来的退款通知字符串
        String A = "oSWxqqMF5lk2EF+gdrdt5wPrOru854za5XjHq5cUXs74zF9+jlxGOo7DHQIuntolVF3kQAruoMoNK5lLRsCulgG2hAT+6sNen8f/f3drMxfsTFOj3aBTKkIHs2p3AVJA4fXpGRCpejq3JJplSQnnSwFljzcxvqe7rU3y/H0KpFyBuYUSEf+msbkHEnHnIHQi4p9JDlLPWoKHramM7R65Qd13GdUU41scNybWCkwl+q/cY2Nv6KUt490JXTbTEgZNE6ArJKGg9woRMUdJEimTnv2OSY16yjo8dlIiozEoHcoQsvSFuMA5DHfHmtk5gbn8y6FVLHbt8XmmOIkfl/CVCXGQ+fGJmazxmqpTLBnAxXogFX2c2h8ZFqrWHW0wWZNSqpRX8HnMBw4V5hUMCiN9ASP3AzkpbtxdkDaeJYagVFgpB7oXxNUlQMy7pCqWCqbhoeLlZtzACx3qNqf57cQLn06T8wrYddf3f78oIYceVWMBses6wcJW2uTUdci4hYOQn5G+iVGLRzMuI8xwQSeBtdrWBor842tEsg4/wgFRxiEgjN+Jl+pCbwULjzt870OwC/UKD9mM3bhyay1jxeKNfkqgks0TH9eZXT1mR6IBfIUipgk9nTrGLFQwt4AAAf7/KoW7A3d1eYGY1vo/QkinixiZsxOJhzw95X6wiiARPa8oe0180lCuhLtIrNRlxyVMbbwA8GQVuCCE6w+/yKIF+el+Gcf7Gm2ljQzV7PEwiomW/DsBqUb5mwGfI52NLRa70kJ8vgaXeMN1xhwWYLzg02muvGGwS2P4kgGO0Sg0L5ycpN7Vp421+HnAPdcW6y/pQi03BKAR6fZT5JQYAIoNN4K8K6ZbgfZiuG32q0q4bwVWrg4jBlyPmj8JwHtbikbAgoJ9sUwWYi7P+Btk1ZHCPLW90p+1mIL8eVpneOaon3mSW0R4JDiIJK8oYLD/1n4NTKRTg9c6OMdSHnK8BUnodw==";
        String A1 = "cgjfwRUwHmtOtNgzdyx7TG5h0Bzed9HWviVBCEO0RTALddh7V/BOsyqR2Mlj4NQKrDO2gBo2KZYTq8amp8Eof1tsUg0RmzkLvTUtmlEFg6KnXTchoPoFKyYIx28fy5yzmxttyWhc+XHY4W1yWxuEfOHkIFun3QgnvsrwK2ANalzjG0+XArjF2WQA8CjnXjHT9N2UGyucDClGSooWSvLSm7F0DLBxgLxT/Lo55/xKtUKpQHZUe5LdZ0hBTR7yKGco9azeGlNL0/Xg1la2FZJFS3XYVQKvjFFVL4EgckEJAlTgnwhIV/iYqgZzcLL4IKBR0YkzdGf62P3OdWOITWeMgLwhpztWYEMJXWBS5w9i+dpABcpK1KjkCXzZm3o4y49h+mUspH1VNDgqxp2k12FuRKrbj6vAmJL72xPqleqHgW3mcaHtrVefablxXdPqGy30Bmy7rs4L2WldrIh3cRJOWqH59HT4Pi9hky4onnWzsn4bAIQm8ADDBdOD4vpzgBWOrgueS0vu/WUGP5oW1CYW9n1kTVdOrR44G7LV39bs5NZ24wzMxv0SF3b3wv0fCwrzjwdGgo6/zmvAoxQRvt2GcJjSFI2tSAunmB+V2h0AINtqzvnc8Qps3PxQJfDQ+ia5xELqKC5TyaH2QI+aS//FH1QTHRLhSApfaLK1IrF6ltq0eTzByKROvHW87Jfwn+UB7Jo/EJWsZo11Ey+lV3pIeT173VLRyJLuDy7Kxrf7NFnMcj4gBeH9/4S9TRcsTUP0LV5chshJUcHhsnd3fAxPjV2ixBAO6vEOvCsafauG9BjUW9nzhTRp6i/3+rePxMBQwWg0mNtvZlsfoyMXjyeNCACKayszMXs4qdl52eNlRKWC6tp8M+2CHNbUoxcRRs24ifxQB6ImCVujl1UcDC/8Wz1B95L0cCfNtDXyAwj/cD5c0VOi46LGdjkf7k0BPE3Ob3zAIu4nj+ET3FjMcn2nYepTsVrdc1ry6ZRyhcjhZjJbGoGvK/Y7JNdNUSWVLhiUCDnfAiTNLwmnPzdJR1yZe9dTLtwLW3KMIvdRgCZNLz3V9YbK+n01fw387QDuZ1ZAjKCxDvvk31nPVgzbexGWnQ==";
        String B = AESUtil.decryptData(A1);
        System.out.println(B);
    }
}
