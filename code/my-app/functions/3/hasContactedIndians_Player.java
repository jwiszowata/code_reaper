public boolean hasContactedIndians() {
    return any(getGame().getLiveNativePlayers(this), p -> hasContacted(p));
}