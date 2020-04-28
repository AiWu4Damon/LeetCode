package com.damon.worm.controllre;

import com.damon.worm.service.TstService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("tst")
public class TstController {
    @Autowired
    private TstService tstService;
    //加入Qulifier注解，通过名称注入bean

    @GetMapping("/test")
    public String test(@RequestParam("testParam")String testParam, HttpServletRequest request){
        String dasda = "dasda";
        char a = 'a';
        return tstService.getUser("damon0425");
    }
}
