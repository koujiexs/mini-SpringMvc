package com.mooc.zbs;

import com.mooc.zbs.starter.MiniApplication;
import com.mooc.zbs.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

/**
 * @author liyang on 2019/10/9
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("hello world");
        MiniApplication.run(Application.class,args);

    }
}
