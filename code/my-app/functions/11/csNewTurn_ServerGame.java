public void csNewTurn(Random random, LogBuilder lb, ChangeSet cs) {
    lb.add("GAME ", getId(), ", ");
    for (Player player : getLivePlayerList()) {
        ((ServerPlayer) player).csNewTurn(random, lb, cs);
    }
    final Specification spec = getSpecification();
    Event succession = spec.getEvent("model.event.spanishSuccession");
    if (succession != null && !getSpanishSuccession()) {
        ServerPlayer loser = csSpanishSuccession(cs, lb, succession);
    }
}