public boolean executeGotoOrders() {
    if (!requireOurTurn())
        return false;
    return doExecuteGotoOrders();
}