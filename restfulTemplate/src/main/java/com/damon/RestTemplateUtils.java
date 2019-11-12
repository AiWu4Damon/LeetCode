package com.damon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static void main1212(String[] args) {
        HashMap<String, String> param = new HashMap<>();
        param.put("syscode","HCZG");
        param.put("flowid","201911071446");
        param.put("requestname","资管接口测试oa连接");
        param.put("workflowname","资管接口测试oa连接");
        param.put("nodename","资管接口测试oa连接");
        param.put("pcurl","www.baidu.com");
        param.put("appurl","");
        param.put("creator","heyuan");
//        createDateTime = "2019-11-07 13:50:09"
        param.put("createdatetime","2019-11-05 15:45:01");
        param.put("receiver","hehaiyue");
        param.put("receivedatetime","2019-11-06 10:07:01");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(JSONObject.toJSONString(param), requestHeaders);
        ResponseEntity<String>exchange= null;
        try {
             exchange = restTemplate.exchange("http://10.2.71.31:80/rest/ofs/ReceiveTodoRequestByJson", HttpMethod.POST, requestEntity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("报错");
        }

        //ResourceAccessException
        HttpStatus statusCode = exchange.getStatusCode();
        System.out.println(statusCode);
        int statusCodeValue = exchange.getStatusCodeValue();
        System.out.println(statusCodeValue);
        System.out.println(exchange.getBody());
//        Map map = JSON.parseObjec
// t(null, Map.class);
//        System.out.println(map);
    }

    public static void main00(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("clientType","1");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(JSONObject.toJSONString(map), requestHeaders);
        ResponseEntity<String> responseEntity=null;
        try {
            responseEntity = restTemplate.exchange("http://115.236.31.83:28090/smr/api/accept/stbInvestor", HttpMethod.POST, requestEntity, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            System.out.println("Url有误访问失败");
        }
        System.out.println("--------------");
        System.out.println(responseEntity.getStatusCodeValue());
        Object body = responseEntity.getBody();
        System.out.println(body);
    }

    public static void main12211(String[] args) {
//        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
//        Map<String, Object> hashMap = new HashMap<>();
//        param.add("appid","HCZG");
//        param.add("loginid","heyuan");
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity<>(param, requestHeaders);
//        ResponseEntity<String> stringResponseEntity=null;
//        try {
//              stringResponseEntity = restTemplate.postForEntity("http://10.2.71.31/ssologin/getToken", requestEntity, String.class);
////            exchange = restTemplate.exchange("http://10.2.71.31/ssologin/getToken", HttpMethod.POST, requestEntity, HashMap.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("报错");
//        }
//        System.out.println(stringResponseEntity.getBody());
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String time = "2019-12-01";
        String replace = time.replace("-", "");
        System.out.println(replace);
    }

}
