private void addSaveAction(JButton button) {
    initializeFilters();
    button.addActionListener((ActionEvent ae) -> {
        File dir = FreeColDirectories.getOptionsDirectory();
        File file = getGUI().showSaveDialog(dir, filters, getDefaultFileName());
        if (file != null) {
            getOptionUI().updateOption();
            save(file);
        }
    });
}