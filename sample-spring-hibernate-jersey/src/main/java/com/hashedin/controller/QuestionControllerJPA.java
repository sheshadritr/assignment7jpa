package com.hashedin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.model.Question;
import com.hashedin.service.QuestionService;

@Controller
public class QuestionControllerJPA {

    @Autowired
    QuestionService questionService;

    @RequestMapping(method=RequestMethod.GET, value = "/questions/persistence")
    public ModelAndView getView(@ModelAttribute("questions") Question question) {
        return new ModelAndView("addQuestion");
    }
    
}
