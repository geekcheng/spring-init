package demo;

import demo.service.DefaultFooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoSpringinitApplication.class)
@SpringBootApplication
public class JdbcTest {
    @Autowired
    private DefaultFooService defaultFooService;

    @Test
    public void jdbcTest(){
        defaultFooService.getFoo("xx");
    }

}
