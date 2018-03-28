public Set<Modifier> getMissionaryTradeModifiers(boolean sense) {
    final Function<Modifier, Modifier> mapper = m -> {
        Modifier mod = new Modifier(m);
        if (!sense)
            mod.setValue(-m.getValue());
        return mod;
    };
    return transform(getModifiers(Modifier.MISSIONARY_TRADE_BONUS), m -> m.getValue() != 0, mapper, Collectors.toSet());
}