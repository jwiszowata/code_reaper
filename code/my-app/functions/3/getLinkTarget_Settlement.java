public FreeColGameObject getLinkTarget(Player player) {
    return (player == getOwner()) ? this : getTile();
}