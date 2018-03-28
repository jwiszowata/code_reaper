protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (ALARM_TAG.equals(tag)) {
        Player player = xr.findFreeColGameObject(game, PLAYER_TAG, Player.class, (Player) null, true);
        if (getName() != null) {
            setContacted(player);
        }
        setAlarm(player, new Tension(xr.getAttribute(VALUE_TAG, 0)));
        xr.closeTag(ALARM_TAG);
    } else if (CONTACT_LEVEL_TAG.equals(tag)) {
        ContactLevel cl = xr.getAttribute(LEVEL_TAG, ContactLevel.class, ContactLevel.UNCONTACTED);
        Player player = xr.findFreeColGameObject(game, PLAYER_TAG, Player.class, (Player) null, true);
        contactLevels.put(player, cl);
        xr.closeTag(CONTACT_LEVEL_TAG);
    } else if (IS_VISITED_TAG.equals(tag)) {
        Player player = xr.findFreeColGameObject(game, PLAYER_TAG, Player.class, (Player) null, true);
        setScouted(player);
        xr.closeTag(IS_VISITED_TAG);
    } else if (MISSIONARY_TAG.equals(tag)) {
        xr.nextTag();
        missionary = xr.readFreeColObject(game, Unit.class);
        missionary.setLocationNoUpdate(this);
        xr.closeTag(MISSIONARY_TAG);
    } else if (OWNED_UNITS_TAG.equals(tag)) {
        Unit unit = xr.makeFreeColObject(game, ID_ATTRIBUTE_TAG, Unit.class, true);
        addOwnedUnit(unit);
        xr.closeTag(OWNED_UNITS_TAG);
    } else {
        super.readChild(xr);
    }
}