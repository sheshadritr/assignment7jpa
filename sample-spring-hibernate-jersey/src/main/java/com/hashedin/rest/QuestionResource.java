package com.hashedin.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Question;
import com.hashedin.model.QuestionAnswers;
import com.hashedin.model.QuestionCount;
import com.hashedin.model.QuestionView;
import com.hashedin.model.Tag;
import com.hashedin.service.QuestionService;


@Component
@Path("/questions")
public class QuestionResource
{

    @Autowired
    private QuestionService questionService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Question> list()
    {
        // Handles GET on /questions. Lists all the questions we have in our system.
        return questionService.findAll();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{questionId}")
    public Question get(@PathParam("questionId") Long questionId)
    {
        // Handles GET on /questions/{questionId}. Returns a single question for the given questionId.
        return questionService.find(questionId);
    }
    
    @GET
    @Path("/{questionId}/tags")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public  List<Tag> findTagsForQuestion(@PathParam("questionId") Long questionId)
    {
        // Handles GET on /questionId/tags fetches tags for a particular question.
        return questionService.findTagsForQuestion(questionId);
    }
    
    @GET
    @Path("/count")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<QuestionCount> findNoOfQuestions()
    {
        // Handles GET on /questions/count. Returns number of questions we have in our system.
        return questionService.findNoOfQuestions();
    }
    
    @GET
    @Path("/views")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public QuestionView findSumOfViews()
    {
        // Handles GET on /questions/count. Returns number of questions we have in our system.
        return questionService.findSumOfViews();
    }
    
    @GET
    @Path("/answers")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public QuestionAnswers findSumOfAnswers()
    {
        // Handles GET on /questions/count. Returns number of questions we have in our system.
        return questionService.findSumOfAnswers();
    }
}
