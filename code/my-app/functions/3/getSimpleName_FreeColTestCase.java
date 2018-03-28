private String getSimpleName(Player player, boolean isCapital) {
    return (isCapital) ? player.getName() + "-capital" : "Settlement-" + settlementNumber++;
}