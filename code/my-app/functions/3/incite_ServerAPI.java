public boolean incite(Unit unit, IndianSettlement is, Player enemy, int gold) {
    return ask(unit.getGame(), new InciteMessage(unit, is, enemy, gold));
}