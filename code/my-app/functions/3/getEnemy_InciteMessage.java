public Player getEnemy(Game game) {
    return game.getFreeColGameObject(getStringAttribute(ENEMY_TAG), Player.class);
}