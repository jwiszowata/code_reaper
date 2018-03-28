public int evaluateFor(Player player) {
    return super.evaluateFor(player) + sum(getProductionInfo().getProduction(), ag -> ag.evaluateFor(player));
}