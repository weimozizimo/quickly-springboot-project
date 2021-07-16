package com.wyf.web.utils;

import cn.hutool.core.date.DateTime;
import com.wyf.web.utils.enums.DateEnum;
import com.wyf.web.utils.enums.DateFormatEnum;

import java.util.HashMap;
import java.util.Map;

/**
*@description 日期工具类，用来填补一些hutool没有的方法
*@author weiyifei
*@date 2020/12/22
*/
public class DateUtil {

    /**
    * @Description: 有时候我们需要根据一个日期的月或者年查询的时候如果使用like语句去查，这样无法使用索引，
     *              所以需要使用时间范围去查询，但是每次都去获取范围会比较麻烦，所以就有了这个工具类
    * @Param: [dateType, date]
    * @return: java.util.Map<java.lang.String,java.lang.String>
    * @Author: weiyifei
    * @Date: 2020/12/22 17:03
    */

    protected static Map<String, String> getDateScopeByDate(DateEnum dateType, String date) {
        String sDate = "";
        String eDate = "";
        Map<String, String> map = new HashMap<>(2);
        DateTime tempDate;
        DateTime sDateTime, eDateTime;
        //根据日期类型来给起始和结束日期赋值
        switch (dateType) {
            case DAY:
                sDate = date;
                eDate = date;
                break;
            case MONTH:
                tempDate = cn.hutool.core.date.DateUtil.parse(date);
                sDateTime = cn.hutool.core.date.DateUtil.beginOfMonth(tempDate);
                eDateTime = cn.hutool.core.date.DateUtil.endOfMonth(tempDate);
                sDate = cn.hutool.core.date.DateUtil.format(sDateTime, DateFormatEnum.DAY_F.getFormat());
                eDate = cn.hutool.core.date.DateUtil.format(eDateTime, DateFormatEnum.DAY_F.getFormat());
                break;
            case YEAR:
                tempDate = cn.hutool.core.date.DateUtil.parse(date);
                sDateTime = cn.hutool.core.date.DateUtil.beginOfYear(tempDate);
                eDateTime = cn.hutool.core.date.DateUtil.endOfYear(tempDate);
                sDate = cn.hutool.core.date.DateUtil.format(sDateTime, DateFormatEnum.DAY_F.getFormat());
                eDate = cn.hutool.core.date.DateUtil.format(eDateTime, DateFormatEnum.DAY_F.getFormat());
                break;
            default:
                break;
        }
        map.put("sDate", sDate);
        map.put("eDate", eDate);
        return map;
    }
    public static String getStartDateScopeByDate(DateEnum dateType, String date){
        Map<String, String> dateScopeByDate = getDateScopeByDate(dateType, date);
        return dateScopeByDate.get("sDate");
    }
    public static String getEndDateScopeByDate(DateEnum dateType, String date){
        Map<String, String> dateScopeByDate = getDateScopeByDate(dateType, date);
        return dateScopeByDate.get("eDate");
    }
}
