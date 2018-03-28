public boolean setStance(Stance stance, Player first, Player second) {
    if (stance == null || first == null || second == null)
        return false;
    final Player player = getMyPlayer();
    Stance old = first.getStance(second);
    try {
        first.setStance(second, stance);
    } catch (IllegalStateException e) {
        logger.log(Level.WARNING, "Illegal stance transition", e);
        return false;
    }
    if (player == first && old == Stance.UNCONTACTED) {
        sound("sound.event.meet." + second.getNationId());
    }
    return true;
}