package ru.rxnnct.dummyclientservergame.website.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "usr")
class User : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @NotBlank(message = "Empty username")
    private var username: String? = null
    @NotBlank(message = "Empty password")
    private var password: String? = null
    @Transient
    private var passwordConfirmation: String? = null
    var isActive = false

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    var roles: MutableSet<Role?>? = null

    override fun getUsername(): String {
        return username!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return isActive
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return roles!!
    }

    override fun getPassword(): String {
        return password!!
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    fun getPasswordConfirmation(): String {
        return password!!
    }

    fun setPasswordConfirmation(password: String?) {
        this.password = password
    }
}