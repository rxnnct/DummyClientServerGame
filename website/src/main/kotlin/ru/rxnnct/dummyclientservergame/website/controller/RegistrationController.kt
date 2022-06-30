package ru.rxnnct.dummyclientservergame.website.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import ru.rxnnct.dummyclientservergame.website.domain.User
import ru.rxnnct.dummyclientservergame.website.service.UserService

@Controller
class RegistrationController(val userService: UserService) {
    @GetMapping("/registration")
    fun registration(): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun addUser(user: User, model: MutableMap<String?, Any?>): String {

        if (!userService.addUser(user)) {
            model["message"] = "User exists!"
            return "registration"
        }

        return "redirect:/login"
    }
}