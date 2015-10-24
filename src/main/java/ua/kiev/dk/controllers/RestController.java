package ua.kiev.dk.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.entities.City;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ComponentScan("ua.kiev.dk")
@Controller
@RequestMapping("/tripcomposer")
public class RestController {

    @RequestMapping(value = "/json")
    public ModelAndView test() throws IOException {
        return new ModelAndView("index");
    }

    @RequestMapping(value="/post",
            method = RequestMethod.POST,
            consumes="application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public City create(@RequestBody City p) {

        System.out.println("DONE!");

        return p;
    }
}

//    public RestController(){
//        System.out.println("init RestController");
//    }

    //this method responses to GET request http://localhost/spring-mvc-json/rest/cont
    // return Person object as json
//
//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody Person get(HttpServletResponse res) {
//
//        Person person = new Person();
//        person.setId(1);
//        person.setName("hmk");
//
//        return person;
//    }

    //this method response to POST request http://localhost/spring-mvc-json/rest/cont/person
    // receives json data sent by client --> map it to Person object
    // return Person object as json
//    @RequestMapping(value=URL,
//                    method = RequestMethod.POST,
//                    produces = "application/json",
//                    headers = "key = $1$12309856$euBrWcjT767K2sP9MHcVS/")
//    public @ResponseBody
//    Person post( @RequestBody final  Person person) {
//
//        System.out.println(person.getId() + " " + person.getName());
//        return person;
//    }

