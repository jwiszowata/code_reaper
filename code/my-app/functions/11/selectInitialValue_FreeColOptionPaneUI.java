public void selectInitialValue(JOptionPane op) {
    if (initialFocusComponent != null) {
        initialFocusComponent.requestFocus();
        if (initialFocusComponent instanceof JButton) {
            JRootPane root = SwingUtilities.getRootPane(initialFocusComponent);
            if (root != null) {
                root.setDefaultButton((JButton) initialFocusComponent);
            }
        }
    }
}