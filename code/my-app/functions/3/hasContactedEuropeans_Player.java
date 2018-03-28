public boolean hasContactedEuropeans() {
    return any(getGame().getLiveEuropeanPlayers(this), p -> hasContacted(p));
}