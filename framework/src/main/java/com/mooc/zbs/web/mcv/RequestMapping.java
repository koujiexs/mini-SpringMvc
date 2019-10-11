package com.mooc.zbs.web.mcv;

import java.lang.annotation.*;

/**
 * @author liyang on 2019/10/10
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
    String value();
}
