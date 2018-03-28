public boolean payForBuilding(Colony colony) {
    if (!requireOurTurn() || colony == null)
        return false;
    if (!getSpecification().getBoolean(GameOptions.PAY_FOR_BUILDING)) {
        getGUI().showInformationMessage("payForBuilding.disabled");
        return false;
    }
    if (!colony.canPayToFinishBuilding()) {
        getGUI().showInformationMessage("info.notEnoughGold");
        return false;
    }
    final int price = colony.getPriceForBuilding();
    StringTemplate t = StringTemplate.template("payForBuilding.text").addAmount("%amount%", price);
    if (!getGUI().confirm(null, t, colony, "yes", "no"))
        return false;
    ColonyWas colonyWas = new ColonyWas(colony);
    boolean ret = askServer().payForBuilding(colony) && colony.getPriceForBuilding() == 0;
    if (ret) {
        colonyWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}