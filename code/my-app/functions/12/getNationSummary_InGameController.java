public NationSummary getNationSummary(Player player) {
    if (player == null)
        return null;
    final Player myPlayer = getMyPlayer();
    NationSummary ns = myPlayer.getNationSummary(player);
    if (ns != null)
        return ns;
    if (askServer().nationSummary(myPlayer, player)) {
        return myPlayer.getNationSummary(player);
    }
    return null;
}