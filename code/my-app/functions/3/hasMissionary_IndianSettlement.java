public boolean hasMissionary(Player player) {
    return missionary != null && player != null && player.owns(missionary);
}