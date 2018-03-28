protected double getNavalStrengthRatio() {
    final Player player = getPlayer();
    double navalAverage = 0.0;
    double navalStrength = 0.0;
    int nPlayers = 0;
    for (Player p : transform(getGame().getLiveEuropeanPlayers(player), x -> !x.isREF())) {
        NationSummary ns = getNationSummary(p);
        if (ns == null)
            continue;
        if (p == player) {
            navalStrength = ns.getNavalStrength();
        } else {
            int st = ns.getNavalStrength();
            if (st >= 0)
                navalAverage += st;
            nPlayers++;
        }
    }
    if (nPlayers <= 0 || navalStrength < 0)
        return -1.0;
    navalAverage /= nPlayers;
    return (navalAverage == 0.0) ? -1.0 : navalStrength / navalAverage;
}