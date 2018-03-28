public boolean setStance(Player player, Stance newStance) {
    if (player == null) {
        throw new IllegalArgumentException("Player must not be 'null'.");
    }
    if (player == this) {
        throw new IllegalArgumentException("Cannot set the stance towards ourselves.");
    }
    if (newStance == null) {
        stance.remove(player.getId());
        return true;
    }
    Stance oldStance = stance.get(player.getId());
    if (newStance == oldStance)
        return true;
    boolean valid = true;
    ;
    if ((newStance == Stance.CEASE_FIRE && oldStance != Stance.WAR) || newStance == Stance.UNCONTACTED) {
        valid = false;
    }
    stance.put(player.getId(), newStance);
    return valid;
}