public List<Player> getLivePlayerList(final Player... exclude) {
    final Predicate<Player> livePred = p -> !p.isUnknownEnemy() && !p.isDead() && !any(exclude, matchKey(p));
    return getPlayerList(livePred);
}