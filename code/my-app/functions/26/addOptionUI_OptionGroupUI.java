private void addOptionUI(Option option, boolean editable) {
    OptionUI ui = optionUIs.get(option.getId());
    if (ui == null) {
        ui = OptionUI.getOptionUI(gui, option, editable);
        if (ui == null) {
            logger.warning("Unknown option type: " + option.toString());
            return;
        }
        if (ui instanceof FreeColActionUI) {
            ((FreeColActionUI) ui).setOptionGroupUI(this);
        }
        if (option.getId() != null) {
            optionUIs.put(option.getId(), ui);
        }
    }
    JLabel label = ui.getJLabel();
    if (label == null) {
        detailPanel.add(ui.getComponent(), "newline, span");
    } else {
        detailPanel.add(label);
        detailPanel.add(ui.getComponent());
    }
    if (group.isEditable()) {
        optionUpdaters.add(ui);
    }
}