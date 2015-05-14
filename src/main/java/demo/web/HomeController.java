package demo.web;

import com.fasterxml.jackson.annotation.JsonView;
import demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.Callable;

/**
 * Created by geek on 2015/5/14.
 */
@RestController
public class HomeController {

//    @Autowired
//    private DeferredResultService resultService;

    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    @JsonView(User.WithoutPasswordView.class)
    public User getUser(){
        return new User("geekcheng","OOoo0000");
    }

    public Callable<String> processUpload(final MultipartFile file){

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "someView";
            }
        };
    }

   /*

     Servlet 3 async processing feature
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>

    public DeferredResult<String> quotes(){
        DeferredResult<String> deferredResult = new DeferredResult<>();
        resultService.getUpdate(deferredResult);
        return deferredResult;
    }
   */
}
