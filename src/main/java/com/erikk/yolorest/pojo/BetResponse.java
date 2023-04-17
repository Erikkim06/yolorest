package com.erikk.yolorest.pojo;

import lombok.Data;

@Data
public class BetResponse {
    private int randomNumber;
    private double winnings;
    private boolean userWin;

    public BetResponse(int randomNumber, double winnings, boolean userWin) {
        this.randomNumber = randomNumber;
        this.winnings = winnings;
        this.userWin = userWin;
    }
    //Setter only for testing purposes

}
