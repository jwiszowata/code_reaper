public void updateEuropeanSubpanels() {
    RecruitPanel rp = getExistingFreeColPanel(RecruitPanel.class);
    if (rp != null)
        rp.update();
    PurchasePanel pp = getExistingFreeColPanel(PurchasePanel.class);
    if (pp != null)
        pp.update();
    TrainPanel tp = getExistingFreeColPanel(TrainPanel.class);
    if (tp != null)
        tp.update();
}