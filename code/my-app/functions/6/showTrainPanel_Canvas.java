public void showTrainPanel() {
    TrainPanel panel = getExistingFreeColPanel(TrainPanel.class);
    if (panel == null) {
        showFreeColPanel(new TrainPanel(freeColClient), null, false);
    }
}