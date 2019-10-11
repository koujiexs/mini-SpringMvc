package com.mooc.zbs.web.mcv;

import java.lang.annotation.*;

/**
 * @author liyang on 2019/10/10
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {
    String value();
}
