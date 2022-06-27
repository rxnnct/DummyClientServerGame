package ru.rxnnct.dummyclientservergame.website.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import ru.rxnnct.dummyclientservergame.website.domain.Role
import ru.rxnnct.dummyclientservergame.website.domain.User
import ru.rxnnct.dummyclientservergame.website.repository.UserRepo
import java.util.*

@Controller
class RegistrationController(val userRepo: UserRepo) {
    @GetMapping("/registration")
    fun registration(): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun addUser(user: User, model: MutableMap<String?, Any?>): String {
        val userFromDb = userRepo.findByUsername(user.username)
        if (userFromDb != null) {
            model["message"] = "User exists!"
            return "registration"
        }
        user.isActive = true
        user.roles = Collections.singleton(Role.USER)
        userRepo.save(user)
        return "redirect:/login"
    }
}