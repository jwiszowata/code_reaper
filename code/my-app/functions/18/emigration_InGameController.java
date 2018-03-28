private void emigration(Player player, int n, boolean fountainOfYouth) {
    final Europe europe = player.getEurope();
    if (europe == null)
        return;
    for (; n > 0 || player.checkEmigrate(); n--) {
        if (!allSame(europe.getRecruitables())) {
            final int nf = n;
            getGUI().showEmigrationDialog(player, fountainOfYouth, (Integer value) -> {
                emigrate(player, Europe.MigrationType.convertToMigrantSlot(value), nf - 1, fountainOfYouth);
            });
            return;
        }
        Unit u = askEmigrate(europe, Europe.MigrationType.getDefaultSlot());
        if (u == null)
            break;
        player.addModelMessage(player.getEmigrationMessage(u));
    }
}