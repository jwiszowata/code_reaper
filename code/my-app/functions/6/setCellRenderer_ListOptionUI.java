private void setCellRenderer(GUI gui, AbstractOption<T> o, boolean editable) {
    OptionUI ui = OptionUI.getOptionUI(gui, o, editable);
    if (ui != null && ui.getListCellRenderer() != null) {
        list.setCellRenderer(ui.getListCellRenderer());
    }
}