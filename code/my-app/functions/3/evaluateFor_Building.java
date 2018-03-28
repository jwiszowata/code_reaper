public int evaluateFor(Player player) {
    return super.evaluateFor(player) + sum(getType().getRequiredGoods(), ag -> ag.evaluateFor(player));
}