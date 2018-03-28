public JToolTip createToolTip() {
    JToolTip toolTip = new RebelToolTip(getFreeColClient(), getColony());
    toolTip.setPreferredSize(new Dimension(400, 185));
    return toolTip;
}