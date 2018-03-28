public Unit getUnit(Game game) {
    return game.getFreeColGameObject(winnerId, Unit.class);
}