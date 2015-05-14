package demo;

import demo.service.DefaultFooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoSpringinitApplication.class)
@WebAppConfiguration
public class DemoSpringinitApplicationTests {

	@Autowired
	private DefaultFooService defaultFooService;
	@Test
	public void contextLoads() {
		System.out.println(defaultFooService.getFoo("test"));
	}

}
