package com.feng.yaxin.authority.utils;


import com.sun.org.apache.regexp.internal.RESyntaxException;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Responser {

    int code;

    private Object message;

    private Map<String, Object> restMap;

    public Responser() {
        this.restMap = new HashMap<>(5);
    }

    /**
     * succeed
     */
    public static Responser succeed() {
        Responser result = new Responser();
        result.setCode(ResponseCode.SUCCEED);
        result.setMessage("succeed!");
        return result;
    }
    public static Responser succeed(String msg) {
        Responser result = new Responser();
        result.setCode(ResponseCode.SUCCEED);
        result.setMessage(msg);
        return result;
    }

    /**
     * fail
     */
    public static Responser fail() {
        Responser responser = new Responser();
        responser.setCode(ResponseCode.FAIL);
        responser.setMessage("fail!");
        return responser;
    }

    public static Responser fail(Object msg) {
        Responser responser = new Responser();
        responser.setCode(ResponseCode.FAIL);
        responser.setMessage(msg);
        return responser;
    }
    /**
     * put (key, value) in
     */
    public Responser put(String key, Object obj) {
        this.restMap.put(key, obj);
        return this;
    }

    /**
     * put obj in key data
     */
    public Responser putData(Object obj) {
        this.restMap.put("data", obj);
        return this;
    }





}
