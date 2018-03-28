public static void addSkipChangeListener(final FreeColClient freeColClient, JMenu menu, final JMenuItem item) {
    final FreeColServer server = freeColClient.getFreeColServer();
    if (server == null)
        return;
    menu.addChangeListener((ChangeEvent e) -> {
        boolean skipping = server.getInGameController().getSkippedTurns() > 0;
        item.setText(Messages.message((skipping) ? "menuBar.debug.stopSkippingTurns" : "menuBar.debug.skipTurns"));
    });
}