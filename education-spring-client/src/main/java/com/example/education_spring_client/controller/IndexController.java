package com.example.education_spring_client.controller;

import com.example.education_spring_client.rest_client.ApiResponse;
import com.example.education_spring_client.rest_client.EducationRestClient;
import java.awt.*;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        List<ApiResponse.Person> teachers = EducationRestClient.getTeachersFromApi();
        model.addAttribute("teachers", teachers);
        return "index";
    }
}
