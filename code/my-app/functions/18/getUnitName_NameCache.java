public static String getUnitName(Player player, UnitType type, Random random) {
    if (!type.isNaval())
        return null;
    String name;
    requireShipNames(player, random);
    synchronized (shipNameLock) {
        List<String> names = shipNames.get(player);
        while (!names.isEmpty()) {
            name = names.remove(0);
            if (player.getUnitByName(name) == null)
                return name;
        }
    }
    final String base = Messages.message("nameCache.base.ship") + "-";
    int i = 1;
    while (player.getUnitByName(name = base + i++) != null) ;
    return name;
}