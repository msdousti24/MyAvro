package io.msdousti.myavro

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Currency

@RestController
class MyController {

    @GetMapping("/hello")
    fun hello(): DomainEvent {
        return DomainEvent(1, "Hello", Currency.getInstance("USD"))
    }

}
