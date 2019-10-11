package com.mooc.zbs.controller;

import com.mooc.zbs.beans.AutoWired;
import com.mooc.zbs.service.SalaryService;
import com.mooc.zbs.web.mcv.Controller;
import com.mooc.zbs.web.mcv.RequestMapping;
import com.mooc.zbs.web.mcv.RequestParam;

/**
 * @author liyang on 2019/10/10
 */
@Controller
public class SalaryController {
    @AutoWired
    private SalaryService salaryService;
    @RequestMapping("/get_salary.json")
    public Integer getSalary(@RequestParam("name") String name,@RequestParam("experience") String experience){
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}
