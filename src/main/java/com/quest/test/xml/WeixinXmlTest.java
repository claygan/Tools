package com.quest.test.xml;

import com.quest.commons.utils.AESUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.quest.commons.utils.UAUtils.PlatformEnum.IOS;

/**
 * Created by Quest on 2018/4/25.
 */
public class WeixinXmlTest {
    @Test
    public void test() throws DocumentException {
//        String xmlString = "<xml><appid>wx4d89c8ad12397c7e</appid><mch_id>1234697102</mch_id><nonce_str>vG9VWDNi0P</nonce_str><body>商务服务包支付</body><detail>商务服务包支付</detail><out_trade_no>de9e0b4f10e346d3bcb9898e1f1d5661</out_trade_no><total_fee>2</total_fee><time_start>20180425211956</time_start><time_expire>20180425214956</time_expire><notify_url>http://61.164.39.67:44890/cfs-pay/weixinpay/feedback</notify_url><trade_type>MWEB</trade_type><scene_info>{\"h5_info\": {\"type\":\"IOS\",\"app_name\":\"亿家健康2.0\",\"bundle_id\":\"com.aijk.wzryIOS\"}}</scene_info><sign>F27C46D2620B73F9CC1869F341ED83E8</sign></xml>\n";
        String xmlString = "{\"transaction_id\":\"4200000157201805041959877896\",\n" +
                "\"refund_status\":\"SUCCESS\",\n" +
                "\"out_refund_no\":\"cdbe92f40bef44199300b996f8299514\",\n" +
                "\"settlement_refund_fee\":\"1\",\n" +
                "\"success_time\":\"2018-05-04 16:16:10\",\n" +
                "\"refund_recv_accout\":\"支付用户零钱\",\n" +
                "\"refund_id\":\"50000006532018050404462338641\",\n" +
                "\"out_trade_no\":\"fc5d590c9e28450181e1ec397ba7aa5e\",\n" +
                "\"refund_account\":\"REFUND_SOURCE_RECHARGE_FUNDS\",\n" +
                "\"refund_fee\":\"1\",\n" +
                "\"total_fee\":\"1\",\n" +
                "\"settlement_total_fee\":\"1\",\n" +
                "\"refund_request_source\":\"API\"}";

        System.out.println(parse(xmlString));
    }
    @Test
    public void parseTest() throws Exception {
        String base64Code = "cgjfwRUwHmtOtNgzdyx7TG5h0Bzed9HWviVBCEO0RTALddh7V/BOsyqR2Mlj4NQKrDO2gBo2KZYTq8amp8Eof1tsUg0RmzkLvTUtmlEFg6KnXTchoPoFKyYIx28fy5yzmxttyWhc+XHY4W1yWxuEfOHkIFun3QgnvsrwK2ANalzjG0+XArjF2WQA8CjnXjHT9N2UGyucDClGSooWSvLSm7F0DLBxgLxT/Lo55/xKtUKpQHZUe5LdZ0hBTR7yKGco9azeGlNL0/Xg1la2FZJFS3XYVQKvjFFVL4EgckEJAlTgnwhIV/iYqgZzcLL4IKBR0YkzdGf62P3OdWOITWeMgLwhpztWYEMJXWBS5w9i+dpABcpK1KjkCXzZm3o4y49h+mUspH1VNDgqxp2k12FuRKrbj6vAmJL72xPqleqHgW3mcaHtrVefablxXdPqGy30Bmy7rs4L2WldrIh3cRJOWqH59HT4Pi9hky4onnWzsn4bAIQm8ADDBdOD4vpzgBWOrgueS0vu/WUGP5oW1CYW9n1kTVdOrR44G7LV39bs5NZ24wzMxv0SF3b3wv0fCwrzjwdGgo6/zmvAoxQRvt2GcJjSFI2tSAunmB+V2h0AINtqzvnc8Qps3PxQJfDQ+ia5xELqKC5TyaH2QI+aS//FH1QTHRLhSApfaLK1IrF6ltq0eTzByKROvHW87Jfwn+UB7Jo/EJWsZo11Ey+lV3pIeT173VLRyJLuDy7Kxrf7NFnMcj4gBeH9/4S9TRcsTUP0LV5chshJUcHhsnd3fAxPjV2ixBAO6vEOvCsafauG9BjUW9nzhTRp6i/3+rePxMBQwWg0mNtvZlsfoyMXjyeNCACKayszMXs4qdl52eNlRKWC6tp8M+2CHNbUoxcRRs24ifxQB6ImCVujl1UcDC/8Wz1B95L0cCfNtDXyAwj/cD5c0VOi46LGdjkf7k0BPE3Ob3zAIu4nj+ET3FjMcn2nYepTsVrdc1ry6ZRyhcjhZjJbGoGvK/Y7JNdNUSWVLhiUCDnfAiTNLwmnPzdJR1yZe9dTLtwLW3KMIvdRgCZNLz3V9YbK+n01fw387QDuZ1ZAjKCxDvvk31nPVgzbexGWnQ==";
        System.out.println(parse(AESUtil.decryptData(base64Code)));
    }



    private Map<String, String> parse(String data) throws DocumentException {
        Map<String, String> params = new HashMap<>();
        Document doc = DocumentHelper.parseText(data);
        Element root = doc.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> elements = root.elements();
        for (Element element : elements) {
            params.put(element.getName(), element.getTextTrim());
        }
        return params;
    }
}
