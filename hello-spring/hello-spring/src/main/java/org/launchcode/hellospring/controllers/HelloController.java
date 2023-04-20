package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at /hello
// @GetMapping("hello")
// @ResponseBody
// public String hello(){
// return "Hello, Spring!";
// }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //lives at /hello/hello
    //Handles request of the form /hell0?name = LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
    public String helloWithQueryParameters(@RequestParam String name){
        return "Hello, " +name +"!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + //submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "helloLanguages")
    @ResponseBody
    public String helloLanguages(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }
        return createMessage(name,language);
    }


    public static String createMessage(String name, String language){
        String greeting = "";
        if(language.equals("")){
            greeting = "Hello";
        } else if(language.equals("spanish")){
            greeting = "Hola";
        } else if(language.equals("french")){
            greeting = "Bonjour";
        }else if(language.equals("german")){
            greeting = "Hallo";
        } else if(language.equals("italian")){
            greeting = "Bonjourno";
        }
        return greeting + " " + name;
    }

    @GetMapping("form2")
    public String helloForm2(){
        return "<html>" +
                "<body>" +
                "<form action = 'helloLanguages' method = 'post'>" + //submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<label for='language-select'>Choose a language:</label>" +
                "<select name='language' id='language-select'>" +
                "<option value=''>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}