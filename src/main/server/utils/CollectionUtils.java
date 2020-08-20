package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
*@description 集合工具类
*@author weiyifei
*@date 2020/8/20
*/
public class CollectionUtils {

    //对一个集合进行深拷贝
    public static <T> List listDeepCopy(List<? super T> sourceList){
        List newList = new ArrayList<T>();

        Collections.addAll(newList,new Object[sourceList.size()]);
        Collections.copy(newList,sourceList);
        return newList;
    }
}
