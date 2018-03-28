public boolean confirmPreCombat(Unit attacker, Tile tile) {
    if (getClientOptions().getBoolean(ClientOptions.SHOW_PRECOMBAT)) {
        Settlement settlement = tile.getSettlement();
        FreeColGameObject defender = (settlement != null) ? settlement : tile.getDefendingUnit(attacker);
        return showPreCombatDialog(attacker, defender, tile);
    }
    return true;
}