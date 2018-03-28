public void addPlayer(Player player) {
    players.add(player);
    Nation nation = getSpecification().getNation(player.getNationId());
    nationOptions.getNations().put(nation, NationState.NOT_AVAILABLE);
    if (getCurrentPlayer() == null)
        setCurrentPlayer(player);
}