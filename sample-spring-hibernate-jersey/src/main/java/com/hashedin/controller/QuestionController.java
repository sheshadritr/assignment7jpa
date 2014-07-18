package com.hashedin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.model.Question;

@Controller
public class QuestionController {

    @RequestMapping(method = RequestMethod.GET, value = "/questions")
    public ModelAndView getView(@ModelAttribute("questions") Question question)
    {

        return new ModelAndView("addQuestion");
    }
    
}
