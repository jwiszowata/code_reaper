public boolean payForBuilding(Colony colony) {
    return ask(colony.getGame(), new PayForBuildingMessage(colony));
}