public void setTension(Player player, Tension newTension) {
    if (player == this || player == null)
        return;
    tension.put(player, newTension);
}