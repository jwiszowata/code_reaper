public void cheatGold(int amount, LogBuilder lb) {
    final Player player = getPlayer();
    int gold = player.getGold();
    if (gold < amount) {
        amount -= gold;
        player.modifyGold(amount);
        lb.add("added ", amount, " gold");
    }
    player.logCheat(amount + " gold");
}