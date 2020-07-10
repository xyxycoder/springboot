package com.xiny.SqlSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqlSessionContext {

    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSession getsession(){
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
       return sqlSessionFactory.openSession();
    }
}
