public int getTreasureAmount() {
    if (!canCarryTreasure()) {
        throw new IllegalStateException("Unit can not carry treasure");
    }
    return treasureAmount;
}