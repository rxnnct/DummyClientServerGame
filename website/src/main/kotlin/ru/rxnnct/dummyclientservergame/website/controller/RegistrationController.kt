package ru.rxnnct.dummyclientservergame.website.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import ru.rxnnct.dummyclientservergame.website.domain.User
import ru.rxnnct.dummyclientservergame.website.service.UserService
import javax.validation.Valid

@Controller
class RegistrationController(val userService: UserService) {
    @GetMapping("/registration")
    fun registration(): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun addUser(@Valid user: User, bindingResult: BindingResult, model: Model): String {
        if (user.password != user.getPasswordConfirmation()){
            model.addAttribute("passwordConfirmationError", "Wrong password!")
        }

        if (bindingResult.hasErrors()) {
            val errors: MutableMap<String, String> = getErrors(bindingResult) as MutableMap<String, String>

            model.mergeAttributes(errors)
            model.addAttribute("map", errors)

            return "registration"
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exists")
            return "registration"
        }

        return "redirect:/login"
    }
}