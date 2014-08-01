/*
 * Copyright (c) 2014. satokitty
 *
 * Licensed under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.example

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = App)
@WebAppConfiguration
@IntegrationTest("server.port:0")
class AppTest {
    @Value('${local.server.port}')
    int port

    RestTemplate restTemplate = new TestRestTemplate()

    @Test
    void testHome() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:${port}", String)
        assert response.getStatusCode() == HttpStatus.OK
        assert response.getBody() == "Hello, Spring."
    }
}
