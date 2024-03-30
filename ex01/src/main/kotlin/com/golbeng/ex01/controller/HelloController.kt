package com.golbeng.ex01.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("hello")
    public fun hello(model:Model) : String {
        model.addAttribute(
            "data",
            "hello!"
        )

        return "hello"
    }

    @GetMapping("hello-mvc")
    public fun helloMvc(
        @RequestParam("name") name:String,
        model : Model
    ) : String {
        model.addAttribute("name", name)

        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody
    public fun helloString(
        @RequestParam("name") name:String
    ) : String {
        return "hello!!, $name"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public fun HelloApi(
        @RequestParam("name") name:String
    ) : Hello {
        val hello:Hello = Hello(name)

        return hello
    }
}

class Hello(var name:String) {

}