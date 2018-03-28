public boolean payArrears(GoodsType type) {
    if (!requireOurTurn() || type == null)
        return false;
    final Player player = getMyPlayer();
    int arrears = player.getArrears(type);
    if (arrears <= 0)
        return false;
    if (!player.checkGold(arrears)) {
        getGUI().showInformationMessage(StringTemplate.template("payArrears.noGold").addAmount("%amount%", arrears));
        return false;
    }
    StringTemplate t = StringTemplate.template("payArrears.text").addAmount("%amount%", arrears);
    if (!getGUI().confirm(null, t, type, "ok", "cancel"))
        return false;
    boolean ret = askServer().payArrears(getGame(), type) && player.canTrade(type);
    if (ret) {
        updateGUI(null);
    }
    return ret;
}