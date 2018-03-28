public boolean showPreCombatDialog(Unit attacker, FreeColGameObject defender, Tile tile) {
    return showFreeColDialog(new PreCombatDialog(freeColClient, frame, attacker, defender), tile);
}