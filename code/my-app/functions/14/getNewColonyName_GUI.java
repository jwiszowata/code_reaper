public String getNewColonyName(Player player, Tile tile) {
    String suggested = player.getSettlementName(null);
    String name = getInput(tile, StringTemplate.template("nameColony.text"), suggested, "accept", "cancel");
    if (name == null) {
    } else if (name.isEmpty()) {
        showInformationMessage("enterSomeText");
    } else if (player.getSettlementByName(name) != null) {
        showInformationMessage(tile, StringTemplate.template("nameColony.notUnique").addName("%name%", name));
    } else {
        return name;
    }
    player.putSettlementName(suggested);
    return null;
}