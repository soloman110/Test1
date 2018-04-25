package com.spring.study.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.spring.study.dao.DemoDao;
import com.spring.study.data.entity.User;
@Repository
public class DemoDaoImpl implements DemoDao {
    @Autowired
    protected HibernateTemplate hibernateTemplateMysql;
    public String test() {
        return "hello word!";
    }
    public void save(Object entity) {
        hibernateTemplateMysql.save(entity);
    }
    public void delete(Object entity) {
        hibernateTemplateMysql.delete(entity);
    }
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
    	List<User> list = (List<User>) hibernateTemplateMysql.find("from com.spring.study.data.entity.User");
    	System.out.print(list);
    	return list;
    }
    @SuppressWarnings({ })
    public Object findById(final int id) {
//      return hibernateTemplateMysql.execute(new HibernateCallback() {
//          @Override
//          public Object doInHibernate(Session session) throws HibernateException {
//              String hql = "from demo_user where id=?";
//              Query query = session.createQuery(hql);
//              query.setParameter(0, id);
//              return query.uniqueResult();
//          }
//      });
    	//새로운 방법: java8 이상
        return hibernateTemplateMysql.execute((Session session)-> {
                String hql = "from User where id=?";
                Query query = session.createQuery(hql);
                query.setParameter(0, id);
                return query.uniqueResult();
        });
    }
}
