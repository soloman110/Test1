package com.spring.study.web.controll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.study.service.DemoService;
@Controller
@RequestMapping("/")
public class DemoController {
    @Autowired
    DemoService demoService;
    @RequestMapping("/test")
    @ResponseBody
    public String testRerutnString(){
        return "Hello Word!";   
    }
    @RequestMapping(value="/save",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String save(String name){
        return "save" + demoService.save(name).toString();  
    }
    @RequestMapping(value="/del",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(int id){
        return "del:" + demoService.delete(id); 
     }
    @RequestMapping(value="/find",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findAll(){
        return "find111:" + demoService.findAll(); 
    }
}