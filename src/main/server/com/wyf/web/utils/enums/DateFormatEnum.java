package com.wyf.web.utils.enums;

/**
*@description 枚举一些较常用的日期格式
*@author weiyifei
*@date 2020/12/22
*/
public enum DateFormatEnum {
    DAY_F("yyyy-MM-dd"),
    DATE_TIME_F("yyyy-MM-dd HH:mm:ss"),
    MONTH_F("yyyy-MM"),
    ;

    private String format;

    DateFormatEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
