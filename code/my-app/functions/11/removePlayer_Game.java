public boolean removePlayer(Player player) {
    Player newCurrent = (currentPlayer != player) ? null : getPlayerAfter(currentPlayer);
    if (!players.remove(player))
        return false;
    Nation nation = getSpecification().getNation(player.getNationId());
    nationOptions.getNations().put(nation, NationState.AVAILABLE);
    player.dispose();
    if (newCurrent != null)
        currentPlayer = newCurrent;
    return true;
}