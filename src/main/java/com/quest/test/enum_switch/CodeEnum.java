package com.quest.test.enum_switch;

/**
 * Created by Quest on 2018/3/21.
 */
public enum CodeEnum {

    SUCCESS("成功",200),FAIL("失败",500),TIMEOUT("超时",403);

    private String symbol;
    private int type;

    CodeEnum(String symbol, int type) {
        this.symbol = symbol;
        this.type = type;
    }

    public static int getTypeBySymbol(String symbol){
        for (CodeEnum e : values()) {
            if (symbol.equals(e.getSymbol())) {
                return e.getType();
            }
        }
        return 0;
    }
    public static CodeEnum getEnumBySymbol(String symbol){
        for (CodeEnum e : values()) {
            if (symbol.equals(e.getSymbol())) {
                return e;
            }
        }
        return null;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getType() {
        return type;
    }
}
