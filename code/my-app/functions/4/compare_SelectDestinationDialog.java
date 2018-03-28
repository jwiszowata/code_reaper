public int compare(Destination choice1, Destination choice2) {
    int result = choice1.turns - choice2.turns;
    return (result != 0) ? result : compareNames(choice1.location, choice2.location);
}