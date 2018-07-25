package com.common.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:ReturnData 
 * Description:返回信息公用类
 * @Edit_Description:
 * @version:shebao-framelib 1.0
 */
public class ReturnData {

    // 操作状态
    private Integer retCode;

    // 返回数据
    private Object data;

    // 错误提示信息
    private String msg;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @Edit_Description 获取返回值.
     * @version:shebao-framelib 1.0.
     */
    public Map<String, Object> getReturnMap() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("retCode", retCode);
        dataMap.put("data", data);
        dataMap.put("msg", msg);
        return dataMap;
    }

    public ReturnData() {
        super();
    }

    /**
     * @Edit_Description 构造函数.
     * @version:shebao-framelib 1.0.
     */
    public ReturnData(int retCode, Object data, String msg) {
        super();
        this.retCode = retCode;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ReturnData [retCode=" + retCode + ", data=" + data + "]";
    }

}
