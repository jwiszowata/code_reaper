public boolean hasVisited(Player player) {
    return getContactLevel(player).ordinal() >= ContactLevel.VISITED.ordinal();
}