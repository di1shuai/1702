package com.diyishuai.hi1702.api.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestUtil {

    public static Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    public static Map getParameterMapAndDropPage(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        properties.forEach((k,v) -> {
            String value = "";
            if (!"current".equals(k) && !"size".equals(k)) {
                if (null == v) {
                    value = "";
                } else if (v instanceof String[]) {
                    String[] values = (String[]) v;
                    for (int i = 0; i < values.length; i++) {
                        value = values[i] + ",";
                    }
                    value = value.substring(0, value.length() - 1);
                } else {
                    value = v.toString();
                }
                returnMap.put(k, value);
            }
        });
        return returnMap;
    }

    /**
     * generate http client info
     *
     * @param request
     * @return
     */
    public static String getHttpClientInfo(HttpServletRequest request) {
        String mark = "::";
        String seperator = "\t";
        String labelRequestUrl = "Request URL";
        String labelRequestMethod = "Request Method";
        String labelClientIp = "Client IP";
        String labelUserAgent = "User Agent";
        String labelRequestParams = "Request Params";

        String clientIp = null;
        if (request.getRemoteAddr() != null) {
            clientIp = request.getRemoteAddr();
        } else if (request.getRemoteHost() != null) {
            clientIp = request.getRemoteHost();
        } else if (request.getHeader("X-FORWARDED-FOR") != null) {
            clientIp = request.getHeader("X-FORWARDED-FOR");
        }
        String restURL = request.getRequestURL().toString();
        String restMethod = request.getMethod();
        String userAgent = request.getHeader("user-agent");

        StringBuilder sb = new StringBuilder();
        sb.append(labelRequestUrl).append(mark).append(restURL).append(seperator);
        sb.append(labelRequestMethod).append(mark).append(restMethod).append(seperator);
        sb.append(labelRequestParams).append(mark).append(RequestUtil.getParameterMap(request)).append(seperator);
        sb.append(labelClientIp).append(mark).append(clientIp).append(seperator);
        sb.append(labelUserAgent).append(mark).append(userAgent).append(seperator);

        return sb.toString();
    }

    /**
     * 获取client ip地址.
     *
     * @param request the request
     * @return the object
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
