package com.spring.study.dao;

import java.util.List;
import com.spring.study.data.entity.User;
public interface DemoDao {
    String test();
    void save(Object entity);
    Object findById(int id);
    void delete(Object entity);
    List<User> findAll();
}
