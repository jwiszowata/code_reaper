public void setTreasureAmount(int amount) {
    if (!canCarryTreasure()) {
        throw new IllegalStateException("Unit can not carry treasure");
    }
    this.treasureAmount = amount;
}