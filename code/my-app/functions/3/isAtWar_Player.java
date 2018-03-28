public boolean isAtWar() {
    return any(getGame().getLivePlayers(), p -> atWarWith(p));
}