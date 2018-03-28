public boolean hasContacted(Player player) {
    return player != null && (player.isEuropean() || getOwner().getStance(player) != Stance.UNCONTACTED);
}