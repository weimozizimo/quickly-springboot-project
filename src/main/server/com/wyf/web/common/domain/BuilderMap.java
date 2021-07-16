package com.wyf.web.common.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyifei
 * @description 以建造者模式的方式来构建map中的元素
 * @date 2021/7/16
 */
public class BuilderMap {

    private Map map;

    public BuilderMap(Map map) {
        this.map = map;
    }

    public static BuilderMap getBuilder() {
        return new BuilderMap(new HashMap());
    }

    public BuilderMap put(Object k, Object v) {
        this.map.put(k, v);
        return this;
    }

    public Map build() {
        return this.map;
    }

}
