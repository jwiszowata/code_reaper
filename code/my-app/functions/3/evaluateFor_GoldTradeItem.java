public int evaluateFor(Player player) {
    return (!isValid()) ? Integer.MIN_VALUE : getGold();
}