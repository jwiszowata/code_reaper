public boolean setBuildQueue(Colony colony, List<BuildableType> buildQueue) {
    if (!requireOurTurn() || colony == null || buildQueue == null)
        return false;
    ColonyWas colonyWas = new ColonyWas(colony);
    boolean ret = askServer().setBuildQueue(colony, buildQueue);
    if (ret) {
        colonyWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}