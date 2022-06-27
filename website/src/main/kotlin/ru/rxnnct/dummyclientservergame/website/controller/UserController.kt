package ru.rxnnct.dummyclientservergame.website.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.rxnnct.dummyclientservergame.website.domain.Role
import ru.rxnnct.dummyclientservergame.website.domain.User
import ru.rxnnct.dummyclientservergame.website.repository.UserRepo
import java.util.*
import java.util.stream.Collectors

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ADMIN')")
class UserController(val userRepo: UserRepo) {

    @GetMapping
    fun userList(model: Model): String {
        model.addAttribute("users", userRepo.findAll())
        return "user_list"
    }

    @GetMapping("{user}")
    fun userEditForm(@PathVariable user: User, model: Model): String {
        model.addAttribute("user", user)
        model.addAttribute("roles", Role.values())

        return "user_edit"
    }

    @PostMapping
    fun userSave(
        @RequestParam username: String?,
        @RequestParam form: Map<String, String?>,
        @RequestParam("userId") user: User
    ): String? {
        user.setUsername(username)
        val roles = Arrays.stream(Role.values())
            .map(Role::name)
            .collect(Collectors.toSet())
        user.roles?.clear()
        for (key in form.keys) {
            if (roles.contains(key)) {
                user.roles?.add(Role.valueOf(key))
            }
        }
        userRepo.save(user)
        return "redirect:/user"
    }
}