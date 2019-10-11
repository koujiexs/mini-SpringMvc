package com.mooc.zbs.service;

import com.mooc.zbs.beans.Bean;

/**
 * @author liyang on 2019/10/11
 */
@Bean
public class SalaryService {
    public Integer calSalary(Integer experience){
        return experience*5000;
    }
}
