private boolean doExecuteGotoOrders() {
    if (getGUI().isShowingSubPanel())
        return false;
    final Player player = getMyPlayer();
    final Unit active = getGUI().getActiveUnit();
    Unit stillActive = null;
    moveMode = moveMode.maximize(MoveMode.EXECUTE_GOTO_ORDERS);
    List<ModelMessage> messages = new ArrayList<>();
    final Predicate<Unit> tradePred = u -> u.isReadyToTrade() && player.owns(u);
    for (Unit unit : transform(player.getUnits(), tradePred, Function.identity(), tradeRouteUnitComparator)) {
        getGUI().setActiveUnit(unit);
        if (moveToDestination(unit, messages))
            stillActive = unit;
    }
    if (!messages.isEmpty()) {
        for (ModelMessage m : messages) {
            player.addModelMessage(m);
            turnReportMessages.add(m);
        }
        displayModelMessages(false, false);
        getGUI().setActiveUnit((stillActive != null) ? stillActive : active);
        return false;
    }
    if (active != null)
        player.setNextGoingToUnit(active);
    boolean fail = false;
    while (player.hasNextGoingToUnit()) {
        Unit unit = player.getNextGoingToUnit();
        getGUI().setActiveUnit(unit);
        if (moveToDestination(unit, null))
            stillActive = unit;
        displayModelMessages(false, false);
        if (getGUI().isShowingSubPanel()) {
            getGUI().requestFocusForSubPanel();
            fail = true;
            break;
        }
    }
    getGUI().setActiveUnit((stillActive != null) ? stillActive : active);
    return stillActive == null && !fail;
}