public boolean setGoodsLevels(Colony colony, ExportData data) {
    return ask(colony.getGame(), new SetGoodsLevelsMessage(colony, data));
}