package com.damon;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
//        HashMap<String, String> param = new HashMap<String, String>();
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
//        String body = null;
//        try {
//            body = restTemplate.exchange("http://t.weather1.sojson.com/api/weather/city/101010100", HttpMethod.GET, requestEntity, String.class, param).getBody();
//        } catch (RestClientException e) {
//            System.out.println("报错");
//        }
//        //ResourceAccessException
//        System.out.println(body);
        Map map = JSON.parseObject(null, Map.class);
        System.out.println(map);
    }

}
