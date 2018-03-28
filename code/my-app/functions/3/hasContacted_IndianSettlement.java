public boolean hasContacted(Player player) {
    return player != null && (player.isIndian() || getContactLevel(player) != ContactLevel.UNCONTACTED);
}