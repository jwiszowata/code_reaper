public void showRecruitPanel() {
    RecruitPanel panel = getExistingFreeColPanel(RecruitPanel.class);
    if (panel == null) {
        showFreeColPanel(new RecruitPanel(freeColClient), null, false);
    }
}