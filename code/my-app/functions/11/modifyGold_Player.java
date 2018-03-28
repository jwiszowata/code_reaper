public int modifyGold(int amount) {
    if (this.gold != Player.GOLD_NOT_ACCOUNTED) {
        if ((gold + amount) >= 0) {
            gold += amount;
        } else {
            logger.warning("Cannot add " + amount + " gold for " + this + ": would be negative!");
            gold = 0;
        }
    }
    return gold;
}