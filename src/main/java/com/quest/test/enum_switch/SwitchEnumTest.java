package com.quest.test.enum_switch;

import org.junit.Test;

/**
 * Created by Quest on 2018/3/21.
 */
public class SwitchEnumTest {
    @Test
    public void test(){
        String value = "成功";
        System.out.println(getResult(value));
    }


    private String getResult(String value){
        switch (CodeEnum.getEnumBySymbol(value)) {
            case SUCCESS:
                return "success" + value;
            case FAIL:
                return "fail" + value;
            case TIMEOUT:
                return "timeout" + value;
            default:
                return "nothing at all";
        }
    }
}
