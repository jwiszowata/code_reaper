public boolean checkGold(int amount) {
    return this.gold == GOLD_NOT_ACCOUNTED || this.gold >= amount;
}