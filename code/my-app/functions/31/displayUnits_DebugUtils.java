public static void displayUnits(final FreeColClient freeColClient) {
    final Player player = freeColClient.getMyPlayer();
    List<Unit> all = player.getUnitList();
    LogBuilder lb = new LogBuilder(256);
    lb.add("\nActive units:\n");
    Unit u, first = player.getNextActiveUnit();
    if (first != null) {
        lb.add(first.toString(), "\nat ", first.getLocation(), "\n");
        all.remove(first);
        while (player.hasNextActiveUnit() && (u = player.getNextActiveUnit()) != first) {
            lb.add(u, "\nat ", u.getLocation(), "\n");
            all.remove(u);
        }
    }
    lb.add("Going-to units:\n");
    first = player.getNextGoingToUnit();
    if (first != null) {
        all.remove(first);
        lb.add(first, "\nat ", first.getLocation(), "\n");
        while (player.hasNextGoingToUnit() && (u = player.getNextGoingToUnit()) != first) {
            lb.add(u, "\nat ", u.getLocation(), "\n");
            all.remove(u);
        }
    }
    lb.add("Remaining units:\n");
    while (!all.isEmpty()) {
        u = all.remove(0);
        lb.add(u, "\nat ", u.getLocation(), "\n");
    }
    freeColClient.getGUI().showInformationMessage(lb.toString());
}