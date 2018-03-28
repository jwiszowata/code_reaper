public String getNameKey() {
    if (getGame().isInClient()) {
        return (isExplored()) ? getType().getNameKey() : "unexplored";
    } else {
        Player player = getGame().getCurrentPlayer();
        if (player != null) {
            return (getCachedTile(player) == null) ? "unexplored" : getType().getNameKey();
        } else {
            logger.warning("player == null");
            return "";
        }
    }
}