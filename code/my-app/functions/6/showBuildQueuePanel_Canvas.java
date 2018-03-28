public void showBuildQueuePanel(Colony colony) {
    BuildQueuePanel panel = getExistingFreeColPanel(BuildQueuePanel.class);
    if (panel == null || panel.getColony() != colony) {
        showSubPanel(new BuildQueuePanel(freeColClient, colony), true);
    }
}