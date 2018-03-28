public void fixClientOptions() {
    addBooleanOption(MINIMAP_TOGGLE_BORDERS, "clientOptions.gui", true);
    addBooleanOption(MINIMAP_TOGGLE_FOG_OF_WAR, "clientOptions.gui", true);
    addTextOption(AUTO_SAVE_PREFIX, "clientOptions.savegames", "Autosave");
    addTextOption(LAST_TURN_NAME, "clientOptions.savegames", "last-turn");
    addTextOption(BEFORE_LAST_TURN_NAME, "clientOptions.savegames", "before-last-turn");
    addBooleanOption(STOCK_ACCOUNTS_FOR_PRODUCTION, "clientOptions.warehouse", false);
    addBooleanOption(AUTOLOAD_SENTRIES, "clientOptions.other", false);
    try {
        RangeOption ro = (RangeOption) getOption(DEFAULT_MINIMAP_ZOOM);
        if (ro.getItemValues().size() != 6) {
            Integer value = ro.getValue();
            ro.clearItemValues();
            ro.addItemValue(1, "1");
            ro.addItemValue(2, "2");
            ro.addItemValue(3, "3");
            ro.addItemValue(4, "4");
            ro.addItemValue(5, "5");
            ro.addItemValue(6, "6");
            ro.setValue(value);
        }
    } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to fix " + DEFAULT_MINIMAP_ZOOM + " option", e);
    }
}