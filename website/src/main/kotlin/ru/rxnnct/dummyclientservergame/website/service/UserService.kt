package ru.rxnnct.dummyclientservergame.website.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.rxnnct.dummyclientservergame.website.domain.Role
import ru.rxnnct.dummyclientservergame.website.domain.User
import ru.rxnnct.dummyclientservergame.website.repository.UserRepo
import java.util.*

@Service
class UserService(val userRepo: UserRepo) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepo.findByUsername(username)!!
    }

    fun addUser(user: User): Boolean{
        val userFromDb = userRepo.findByUsername(user.username)

        if (userFromDb != null) {
            return false
        }

        user.isActive = true
        user.roles = Collections.singleton(Role.USER)

        userRepo.save(user)


        return true
    }
}