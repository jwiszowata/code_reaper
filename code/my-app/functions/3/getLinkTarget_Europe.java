public FreeColGameObject getLinkTarget(Player player) {
    return (getOwner() == player) ? this : null;
}