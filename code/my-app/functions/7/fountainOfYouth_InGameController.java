public void fountainOfYouth(int n) {
    final Player player = getMyPlayer();
    final boolean fountainOfYouth = true;
    getGUI().showEmigrationDialog(player, fountainOfYouth, (Integer value) -> {
        emigrate(player, Europe.MigrationType.convertToMigrantSlot(value), n - 1, fountainOfYouth);
    });
}