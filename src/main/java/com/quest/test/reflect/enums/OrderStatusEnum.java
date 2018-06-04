package com.quest.test.reflect.enums;

/**
 * 订单状态枚举
 */
public enum OrderStatusEnum {
    ORDER_STATUS_UNPAID("21","待支付"),ORDER_STATUS_PAID("22","付款成功"),ORDER_STATUS_CLOSED("23","关闭订单"),ORDER_STATUS_CANCELED("24","取消订单");

    private String code;
    private String text;

    OrderStatusEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getTextByCode(String code) {
        for (OrderStatusEnum e : values()) {
            if (code.equals(e.getCode())) {
                return e.getText();
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }
    public String getText() {
        return text;
    }

}
