private void removeEuropeanSubpanels() {
    FreeColPanel panel;
    if ((panel = getExistingFreeColPanel(RecruitPanel.class)) != null)
        removeFromCanvas(panel);
    if ((panel = getExistingFreeColPanel(PurchasePanel.class)) != null)
        removeFromCanvas(panel);
    if ((panel = getExistingFreeColPanel(TrainPanel.class)) != null)
        removeFromCanvas(panel);
}