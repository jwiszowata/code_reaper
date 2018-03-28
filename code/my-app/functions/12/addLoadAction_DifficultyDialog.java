private void addLoadAction(JButton button) {
    initializeFilters();
    button.addActionListener((ActionEvent ae) -> {
        File dir = FreeColDirectories.getOptionsDirectory();
        File file = getGUI().showLoadDialog(dir, filters);
        if (file != null && load(file)) {
            invalidate();
            validate();
            repaint();
        }
    });
}