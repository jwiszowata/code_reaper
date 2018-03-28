private boolean askClearGotoOrders(Unit unit) {
    if (!askAssignTradeRoute(unit, null))
        return false;
    if (unit.getDestination() == null)
        return true;
    if (askSetDestination(unit, null)) {
        getGUI().clearGotoPath();
        return true;
    }
    return false;
}