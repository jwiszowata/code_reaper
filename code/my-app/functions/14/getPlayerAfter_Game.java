public Player getPlayerAfter(Player beforePlayer) {
    if (players.isEmpty())
        return null;
    final int start = players.indexOf(beforePlayer);
    int index = start;
    do {
        if (++index >= players.size())
            index = 0;
        Player player = players.get(index);
        if (!player.isUnknownEnemy() && !player.isDead())
            return player;
    } while (index != start);
    return null;
}