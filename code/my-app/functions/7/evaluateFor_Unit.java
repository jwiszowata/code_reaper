public int evaluateFor(Player player) {
    final Europe europe = player.getEurope();
    if (player.isAI() && player.getUnitCount() < 10) {
        return Integer.MIN_VALUE;
    }
    return (europe == null) ? 500 : europe.getUnitPrice(getType());
}