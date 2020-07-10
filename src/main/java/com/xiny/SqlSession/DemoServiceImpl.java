package com.xiny.SqlSession;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DemoServiceImpl {

    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private SqlSessionContext sqlSessionContext;

    public void test() {
        SqlSession sqlSession = sqlSessionContext.getsession();
        Connection connection = sqlSession.getConnection();
        SqlSession sqlSession1 = sqlSessionContext.getsession();
        Connection connection1 = sqlSession1.getConnection();
        Boolean b=true;
        try {
            connection.setAutoCommit(false);
            connection1.setAutoCommit(false);

            DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
            DemoMapper mapper1 = sqlSession1.getMapper(DemoMapper.class);
            List<Callable<Boolean>> resultList = new ArrayList<>();
            resultList.add(() -> this.getthis(mapper));
            resultList.add(() -> this.getthis(mapper1));
            List<Future<Boolean>> futureList = MyExecutor.getExecutor().invokeAll(resultList);
            for (Future<Boolean> future:futureList) {
                if(!future.get()){
                    b=false;
                    break;
                }
            }
            if(b){
                connection.commit();
                connection1.commit();
            }else {
                connection.rollback();
                connection1.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
            sqlSession1.close();
        }
    }

    private Boolean getthis(DemoMapper mapper) {
        demoMapper.queryList();
        return true;
    }
}
