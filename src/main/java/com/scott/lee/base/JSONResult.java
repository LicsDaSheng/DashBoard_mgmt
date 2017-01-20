package com.scott.lee.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回结果对象
 * Created by Scott on 2017/1/17.
 */
public class JSONResult<E> {

    public JSONResult(){};

    public JSONResult(String message){
        this.message = message;
    }

    public JSONResult(boolean success,String message){
        this.success=success;
        this.message=message;
    }

    public JSONResult(boolean success,String message,E e){
        this.success=success;
        this.message=message;
        this.data = e;
    }

    public JSONResult(boolean success,String message,List<E> e){
        this.success=success;
        this.message=message;
        this.list = e;
    }

    /**
     * 操作结果状态,默认为true
     */
    private boolean success = true;

    /**
     * 操作提示
     */
    private String  message = "操作成功";

    /**
     * 结果对象
     */
    private E data =null;

    private List<E> list = new ArrayList<E>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
