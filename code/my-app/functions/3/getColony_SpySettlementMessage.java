public Colony getColony(Game game) {
    return game.getFreeColGameObject(this.settlementId, Colony.class);
}