package com.anteater.fengfang.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private static Logger logger= Logger.getLogger(MainController.class);
    @RequestMapping(value="/")
    public ModelAndView GoToIndex(){
        return new ModelAndView("index");
    }
}
