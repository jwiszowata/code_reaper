public Stance getStance(Player player) {
    return (player == null || stance.get(player.getId()) == null) ? Stance.UNCONTACTED : stance.get(player.getId());
}