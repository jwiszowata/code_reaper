public static JButton getMessageButton(String key, String val, Player player, FreeColGameObject source) {
    FreeColGameObject link = null;
    if ("%colony%".equals(key) || key.endsWith("Colony%")) {
        Settlement settlement = player.getGame().getSettlementByName(val);
        link = (settlement == null) ? null : (player.owns(settlement)) ? settlement : settlement.getTile();
    } else if ("%europe%".equals(key) || "%market%".equals(key)) {
        link = player.getEurope();
    } else if ("%location%".equals(key) || key.endsWith("Location%")) {
        if (source instanceof Location) {
            link = source.getLinkTarget(player);
        }
    } else if ("%unit%".equals(key)) {
        if (source instanceof Unit && player.owns((Unit) source)) {
            link = source.getLinkTarget(player);
        }
    } else if ("%enemyUnit%".equals(key)) {
        if (source instanceof Unit && !player.owns((Unit) source)) {
            link = source.getLinkTarget(player);
        }
    }
    return (link == null) ? null : getLinkButton(val, null, link.getId());
}