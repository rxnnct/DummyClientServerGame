package ru.rxnnct.dummyclientservergame.website.controller

import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import java.util.stream.Collector
import java.util.stream.Collectors

fun getErrors(bindingResult: BindingResult): Map<String, String>? {
    val collector: Collector<FieldError, *, Map<String, String>> = Collectors.toMap(
        { fieldError: FieldError -> fieldError.field + "Error" }
    ) { obj: FieldError -> obj.defaultMessage }
    return bindingResult.fieldErrors.stream().collect(collector)
}