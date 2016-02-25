package com.exporter.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    //@PreAuthorize("isAnonymous()")
    @RequestMapping("/login")
    public ModelAndView userLogin(@RequestParam(value = "failed", defaultValue = "false")boolean failed,
                                  @RequestParam(value = "error", defaultValue = "false")boolean error) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("failed", failed);
        modelAndView.addObject("error", error);
        return modelAndView;
    }

//    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/")
    public ModelAndView dashBoard() {
        return new ModelAndView("index");
    }
}
