package demo.service;

import demo.domain.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by geek on 2015/5/14.
 */
@Service
public class DefaultFooService implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Foo getFoo(String fooName) {
        System.out.println(jdbcTemplate);
        Integer a = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        System.out.println(a);
        return null;
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        return null;
    }

    @Override
    public void insertFoo(Foo foo) {

    }

    @Override
    public void updateFoo(Foo foo) {

    }
}
