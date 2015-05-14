package demo.service;

import demo.domain.Foo;

/**
 * Created by geek on 2015/5/14.
 */
public interface FooService {
    Foo getFoo(String fooName);
    Foo getFoo(String fooName, String barName);
    void insertFoo(Foo foo);
    void updateFoo(Foo foo);
}
