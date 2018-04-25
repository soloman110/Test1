package com.spring.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.study.dao.DemoDao;
import com.spring.study.data.entity.User;
import com.spring.study.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoDao demoDao;
    public String test() {
        return demoDao.test();  }
    public Object save(String name) {
        User user = new User(name);
        demoDao.save(user);
        return user;    }
    public boolean delete(int id) {
        User user = (User) demoDao.findById(id);
        if(user==null)  return false;
        demoDao.delete(user);
        return true;    }
    public String findAll() {
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        String r = "";
        for(User user : demoDao.findAll())    
        	r +=  user;
        return r;   
    }
}
