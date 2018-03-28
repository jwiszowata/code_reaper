public void showBuildQueuePanel(Colony colony, Runnable callBack) {
    FreeColPanel panel = new BuildQueuePanel(freeColClient, colony);
    panel.addClosingCallback(callBack);
    showSubPanel(panel, true);
}