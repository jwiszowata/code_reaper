public FreeColGameObject getLinkTarget(Player player) {
    return (hasTile()) ? (FreeColGameObject) getTile().up() : player.getEurope();
}