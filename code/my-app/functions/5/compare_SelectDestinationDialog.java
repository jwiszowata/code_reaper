public int compare(Destination choice1, Destination choice2) {
    int score1 = choice1.score;
    int score2 = choice2.score;
    return (score1 != score2) ? score1 - score2 : compareNames(choice1.location, choice2.location);
}