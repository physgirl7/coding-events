package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {


    @GetMapping
    @ResponseBody
    public String landingPage(){
        String greeting = "<h1>Skills Tracker</h1>"+
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>"+
                "<li>Java</li>"+
                "<li>JavaScript</li>"+
                "<li>Python</li>";
        return greeting;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "formPost")
    @ResponseBody
    public String formPost(@RequestParam String name, @RequestParam String language,@RequestParam String language2, @RequestParam String language3){
        String formPostOutput =
                "<html>" +
                        "<body>" +
                        "<h1>" + name + "</h1>" +
                        "<ol>" +
                        "<li>" + language + "</li>" +
                        "<li>" + language2 + "</li>" +
                        "<li>" + language3 + "</li>";
        return formPostOutput;
    }

    @GetMapping("form")
    @ResponseBody
    public String formPage(){
        String form =
                "<html>" +
                        "<body>" +

                "<h2>Name:</h2>" +
                "<form action = 'formPost' method = 'post'>" +
                "<input type = 'text' name = 'name'>" +
                "<h2>My favorite language:</h2>" +
                "<select name = 'language' id = 'language-select'>" +
                "<option value = 'Java'>Java</option>" +
                "<option value = 'Javascript'>JavaScript</option>" +
                "<option value = 'Python'>Python</option>" +
                "</select>" +
//                        "<input type = 'submit' value = 'Submit'>" +
//                        "</form>" +
//                        "<form action = 'formPost' method = 'post'>" +
                        "<h2>My second favorite language:</h2>" +
                        "<select name = 'language2' id = 'language-select'>" +
                        "<option value = 'Java'>Java</option>" +
                        "<option value = 'Javascript'>JavaScript</option>" +
                        "<option value = 'Python'>Python</option>" +
                        "</select>" +
                        "<h2>My third favorite language:</h2>" +
                        "<select name = 'language3' id = 'language-select'>" +
                        "<option value = 'Java'>Java</option>" +
                        "<option value = 'Javascript'>JavaScript</option>" +
                        "<option value = 'Python'>Python</option>" +
                        "</select>" +
                        "<br>" +
                        "<input type = 'submit' value = 'Submit'>" +
                        "</form>" +
                        "</body>" +
                        "</html>";

        return form;

    }
}
