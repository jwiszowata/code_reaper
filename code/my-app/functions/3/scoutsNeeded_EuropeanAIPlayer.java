public int scoutsNeeded() {
    return 3 - (getGame().getTurn().getNumber() / 100);
}