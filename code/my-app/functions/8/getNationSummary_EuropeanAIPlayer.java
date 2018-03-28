protected NationSummary getNationSummary(Player other) {
    final Player player = getPlayer();
    NationSummary ns = player.getNationSummary(other);
    if (ns != null)
        return ns;
    AIMessage.askNationSummary(this, other);
    return player.getNationSummary(other);
}