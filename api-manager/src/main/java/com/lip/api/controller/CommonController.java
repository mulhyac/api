package com.lip.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
@Controller
public class CommonController {
    @RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
    public ModelAndView goToPage(@PathVariable("pageName") String pageName) {
        ModelAndView view=new ModelAndView(pageName);
        return view;
    }
    @RequestMapping(value = "/p/{pid}", method = RequestMethod.GET)
    public ModelAndView goToProjectPage(@PathVariable("pid") String pid) {
        ModelAndView view=new ModelAndView("api");
        view.addObject("pid",pid);
        return view;
    }
    @RequestMapping(value = "/doc/{pid}", method = RequestMethod.GET)
    public ModelAndView goToDocPage(@PathVariable("pid") String pid) {
        ModelAndView view=new ModelAndView("doc");
        view.addObject("pid",pid);
        return view;
    }

}
