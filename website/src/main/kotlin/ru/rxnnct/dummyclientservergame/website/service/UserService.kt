package ru.rxnnct.dummyclientservergame.website.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.rxnnct.dummyclientservergame.website.repository.UserRepo

@Service
class UserService(val userRepo: UserRepo) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepo.findByUsername(username)!!
    }
}