public Stream<Player> getLiveNativePlayers(final Player... exclude) {
    return getLiveNativePlayerList(exclude).stream();
}