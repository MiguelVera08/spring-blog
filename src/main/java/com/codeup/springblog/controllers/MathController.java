package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MathController {



    @RequestMapping(path = "/add/{numOne}/and/{numTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numOne, @PathVariable int numTwo){

        return numOne + numTwo + "";

    }

    @RequestMapping(path = "/subtract/{numOne}/from/{numTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int numOne, @PathVariable int numTwo){

        return (numTwo - numOne) + "";

    }

    @RequestMapping(path = "/multiply/{numOne}/and/{numTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int numOne, @PathVariable int numTwo){

        return numTwo * numOne + "";

    }


    @RequestMapping(path = "/divide/{numTwo}/by/{numOne}", method = RequestMethod.GET)
    @ResponseBody
    public double divide(@PathVariable double numOne, @PathVariable double numTwo){

        return (numTwo / numOne);

    }


}
