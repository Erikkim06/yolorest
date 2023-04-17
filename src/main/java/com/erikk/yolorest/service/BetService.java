package com.erikk.yolorest.service;

import com.erikk.yolorest.pojo.BetRequest;
import com.erikk.yolorest.pojo.BetResponse;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class BetService {
    public BetResponse placeBet(BetRequest betRequest) {
        Random random = new Random();
        int randomNumber = random.nextInt(1, 101);
        boolean userWins = randomNumber < betRequest.getNumber();
        double winnings = userWins ? (betRequest.getBetAmount() * (99 / (100 - betRequest.getNumber()))) : 0;

        return new BetResponse(randomNumber, winnings, userWins);
    }
}
