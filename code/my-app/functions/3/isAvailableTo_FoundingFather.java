public boolean isAvailableTo(Player player) {
    return (!player.isEuropean()) ? false : appliesTo((FreeColObject) player);
}