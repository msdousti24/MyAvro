package io.msdousti.myavro

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(MyController::class)
class MyControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun hello() {
        mockMvc.get("/hello")
            .andExpect {
                status { isOk() }
            }
    }
}
