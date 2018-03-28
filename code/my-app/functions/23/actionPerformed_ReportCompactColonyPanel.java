public void actionPerformed(ActionEvent ae) {
    final Game game = getGame();
    String command = ae.getActionCommand();
    if (command.startsWith(BUILDQUEUE)) {
        command = command.substring(BUILDQUEUE.length());
        Colony colony = game.getFreeColGameObject(command, Colony.class);
        if (colony != null) {
            getGUI().showBuildQueuePanel(colony, () -> {
                update();
            });
            return;
        }
    } else {
        Colony colony = game.getFreeColGameObject(command, Colony.class);
        if (colony != null) {
            getGUI().showColonyPanel2(colony, null).addClosingCallback(() -> {
                update();
            });
            return;
        }
    }
    super.actionPerformed(ae);
}