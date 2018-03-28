protected Container createButtonArea() {
    Object[] buttons = getButtons();
    prepareButtons(buttons);
    JPanel bottom;
    if (this.okIndex >= 0) {
        bottom = new MigPanel(new MigLayout("insets dialog"));
    } else {
        bottom = new MigPanel(new MigLayout("wrap " + getColumns(buttons.length)));
    }
    bottom.setOpaque(false);
    bottom.setName("OptionPane.buttonArea");
    addButtonComponents(bottom, buttons, getInitialValueIndex());
    bottom.setSize(bottom.getPreferredSize());
    return bottom;
}