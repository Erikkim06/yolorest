package com.erikk.yolorest;

import com.erikk.yolorest.pojo.BetRequest;
import com.erikk.yolorest.pojo.BetResponse;
import com.erikk.yolorest.service.BetService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BetTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    BetService betService;

    @Test
    public void testGivenParametersIntegration() throws InterruptedException {
        BetRequest request = new BetRequest(50, 40.5);
        ResponseEntity<BetResponse> response = restTemplate.postForEntity("/bet", request, BetResponse.class);
        if(Objects.requireNonNull(response.getBody()).isUserWin()) {
            Assert.assertEquals(response.getBody().getWinnings(), (40.5 * (99.0 / (100.0 - 50.0))), 0.0);
        }
        Objects.requireNonNull(response.getBody()).setRandomNumber(10);
        Thread.sleep(100);
        Assert.assertEquals(response.getBody().getWinnings(), (40.5 * (99.0 / (100.0 - 50.0))), 0.0);
    }

    @Test
    public void testGivenParametersUnit() {
        BetRequest request = new BetRequest(50, 40.5);
        BetResponse response = betService.placeBet(request);
        Assert.assertNotNull(response);
    }
}
