public FreeColGameObject getLinkTarget(Player player) {
    return (player == getOwner()) ? getOwner().getEurope() : null;
}