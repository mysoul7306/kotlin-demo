package kr.co.rokroot.kotlin.demo.rest.api

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class RestAPIApplication : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(RestAPIApplication::class.java, *args)
        }
    }
}
