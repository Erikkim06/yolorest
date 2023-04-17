package com.erikk.yolorest.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BetRequest {
    @NotNull
    @Positive
    private double number;
    @NotNull
    @Positive
    private double betAmount;

    public BetRequest(double number, double betAmount) {
        this.number = number;
        this.betAmount = betAmount;
    }
}
