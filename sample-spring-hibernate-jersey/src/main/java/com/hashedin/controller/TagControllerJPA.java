package com.hashedin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.model.Tag;
import com.hashedin.service.TagService;

@Controller
public class TagControllerJPA {

    @Autowired
    TagService tagService;

    @RequestMapping(method=RequestMethod.GET, value = "/tags/persistence")
    public ModelAndView getView(@ModelAttribute("tags") Tag tag) {
        return new ModelAndView("addTag");
    }
    
}
