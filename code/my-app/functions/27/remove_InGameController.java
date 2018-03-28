public void remove(List<FreeColGameObject> objects, FreeColGameObject divert) {
    final Player player = getMyPlayer();
    boolean visibilityChange = false;
    for (FreeColGameObject fcgo : objects) {
        if (divert != null)
            player.divertModelMessages(fcgo, divert);
        if (fcgo instanceof Settlement) {
            Settlement settlement = (Settlement) fcgo;
            if (settlement.getOwner() != null) {
                settlement.getOwner().removeSettlement(settlement);
            }
            visibilityChange = true;
        } else if (fcgo instanceof Unit) {
            Unit u = (Unit) fcgo;
            if (u == getGUI().getActiveUnit()) {
                getGUI().setActiveUnit(null);
            }
            if (u.getOwner() != null)
                u.getOwner().removeUnit(u);
            visibilityChange = true;
        }
        fcgo.disposeResources();
    }
    if (visibilityChange)
        player.invalidateCanSeeTiles();
    getGUI().refresh();
}