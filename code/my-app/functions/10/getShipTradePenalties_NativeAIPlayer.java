private List<Modifier> getShipTradePenalties(boolean sense) {
    final Specification spec = getSpecification();
    final int penalty = ((sense) ? 1 : -1) * spec.getInteger(GameOptions.SHIP_TRADE_PENALTY);
    final Function<Modifier, Modifier> mapper = m -> {
        Modifier n = new Modifier(m);
        n.setValue(penalty);
        return n;
    };
    return transform(spec.getModifiers(Modifier.SHIP_TRADE_PENALTY), alwaysTrue(), mapper);
}