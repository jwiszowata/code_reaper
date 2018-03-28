public Tension getTension(Player player) {
    if (player == null)
        throw new IllegalStateException("Null player.");
    Tension newTension = tension.get(player);
    if (newTension == null) {
        newTension = new Tension(Tension.TENSION_MIN);
        tension.put(player, newTension);
    }
    return newTension;
}