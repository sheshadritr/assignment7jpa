package com.hashedin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.model.Tag;

@Controller
public class TagController {

    @RequestMapping(method = RequestMethod.GET, value = "/tags")
    public ModelAndView getView(@ModelAttribute("tags") Tag tag)
    {
    	
        return new ModelAndView("addTag");
    }
    
}

