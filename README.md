# yolorest

Port: 8080

Endpoint: /bet

localhost:8080/bet

Message format:

{

"number": xxx,

"betAmount": xxx

}

Response:

If the user wins -> 

{
    "randomNumber": xxx,
    "winnings": xxx,
    "userWin": true
}


If the user loses -> 

{
    "randomNumber": xxx,
    "winnings": xxx,
    "userWin": false
}

