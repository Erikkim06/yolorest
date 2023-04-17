package com.erikk.yolorest.controllers;

import com.erikk.yolorest.pojo.BetRequest;
import com.erikk.yolorest.pojo.BetResponse;
import com.erikk.yolorest.service.BetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetController {
    @Autowired
    BetService betService;

    @PostMapping("/bet")
    public BetResponse placeBet(@RequestBody @Valid BetRequest betRequest) {
        return betService.placeBet(betRequest);
    }
}
