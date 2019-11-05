package com.damon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestTemplateUtils
 * <br/>
 *
 * @author F88886
 * @date 2019/10/10 15:31
 */
public class RestTemplateUtils {

    public static void main(String[] args) {
        HashMap<String, String> param = new HashMap<>();
        param.put("syscode","HCZG");
        param.put("flowid","201911051545");
        param.put("requestname","资管接口测试oa连接");
        param.put("workflowname","资管接口测试oa连接");
        param.put("nodename","资管接口测试oa连接");
        param.put("pcurl","www.baidu.com");
        param.put("appurl","");
        param.put("creator","hebingpeng2947");
        param.put("createdatetime","2019-11-05 15:45:01");
        param.put("receiver","helimei");
        param.put("receivedatetime","2019-11-05 15:45:01");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        ResponseEntity<String>exchange= null;
        try {
             exchange = restTemplate.exchange("http://10.2.71.31:80/rest/ofs/ReceiveTodoRequestByJson", HttpMethod.POST, requestEntity, String.class, JSONObject.toJSON(param));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("报错");
        }
        //ResourceAccessException
//        System.out.println(body);
        HttpStatus statusCode = exchange.getStatusCode();
        System.out.println(statusCode);
        int statusCodeValue = exchange.getStatusCodeValue();
        System.out.println(statusCodeValue);
//        Map map = JSON.parseObjec
// t(null, Map.class);
//        System.out.println(map);
    }

    public static void main3(String[] args) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("syscode","HCZG");
        param.put("flowid","201911051545");
        param.put("requestname","资管接口测试oa连接");
        param.put("workflowname","资管接口测试oa连接");
        param.put("nodename","资管接口测试oa连接");
        param.put("nodename2",2);
        System.out.println(JSONObject.toJSONString(param));
        System.out.println("------");
        System.out.println(param);
    }

}
