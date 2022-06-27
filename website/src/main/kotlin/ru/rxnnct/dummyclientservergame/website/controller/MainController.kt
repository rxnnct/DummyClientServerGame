package ru.rxnnct.dummyclientservergame.website.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/")
    fun landing(): String {
        return "landing"
    }

    @GetMapping("/main")
    fun main(): String {
        return "main"
    }
}