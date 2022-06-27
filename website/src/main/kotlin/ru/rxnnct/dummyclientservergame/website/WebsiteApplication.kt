package ru.rxnnct.dummyclientservergame.website

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
class WebsiteApplication

fun main(args: Array<String>) {
	runApplication<WebsiteApplication>(*args)
}
