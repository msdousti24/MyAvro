package io.msdousti.myavro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyAvroApplication

fun main(args: Array<String>) {
    runApplication<MyAvroApplication>(*args)
}
