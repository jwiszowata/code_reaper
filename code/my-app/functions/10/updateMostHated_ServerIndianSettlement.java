public boolean updateMostHated() {
    final Player old = this.mostHated;
    final Predicate<Player> hatedPred = p -> {
        Tension alarm = getAlarm(p);
        return alarm != null && alarm.getLevel() != Tension.Level.HAPPY;
    };
    final Comparator<Player> mostHatedComp = Comparator.comparingInt(p -> getAlarm(p).getValue());
    this.mostHated = maximize(getGame().getLiveEuropeanPlayers(), hatedPred, mostHatedComp);
    return this.mostHated != old;
}