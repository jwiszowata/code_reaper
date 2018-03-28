public void emigrate(Player player, int slot, int n, boolean foY) {
    if (player == null || !player.isColonial() || !MigrationType.validMigrantSlot(slot))
        return;
    if (askEmigrate(player.getEurope(), slot) != null) {
        emigration(player, n, foY);
    }
}