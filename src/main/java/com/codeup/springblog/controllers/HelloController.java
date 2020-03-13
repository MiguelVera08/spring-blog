package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("/fruit")
    public String fruit(Model model){
        List<String> fruitBasket = new ArrayList<>();
        fruitBasket.add("pear");
        fruitBasket.add("kiwi");
        fruitBasket.add("mango");
        fruitBasket.add("grapes");
        fruitBasket.add("starfruit");
        fruitBasket.add("japanese pear");
        fruitBasket.add("dorian");
        model.addAttribute("fruitBasket", fruitBasket);
        return "fruit";
    }
}