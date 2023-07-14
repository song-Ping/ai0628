package com.example.test0703.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration //객체 담는 이노테이션
public class MyConf {
    @Autowired
    DataSource dataSource;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:mybatis/sql/*.xml"));
        //mybatis폴더 안에있는 모든 xml(sql구문)을 실행시켜라는 의미

        return sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dbs = new BasicDataSource();
//        dbs.setUrl("jdbc:mysql://localhost:3306/test");
//        dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dbs.setUsername("root");
//        dbs.setPassword("1234");
//        dbs.setInitialSize(10);
//        return dbs;
//    }
}
