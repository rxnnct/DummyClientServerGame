package ru.rxnnct.dummyclientservergame.website.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rxnnct.dummyclientservergame.website.domain.User

interface UserRepo : JpaRepository<User?, Long?> {
    fun findByUsername(username: String?): User?
}