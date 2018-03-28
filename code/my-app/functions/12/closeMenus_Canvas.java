public void closeMenus() {
    for (JInternalFrame frame : getAllFrames()) {
        for (Component c : frame.getContentPane().getComponents()) {
            notifyClose(c, frame);
        }
        frame.dispose();
    }
    while (!dialogs.isEmpty()) {
        FreeColDialog<?> dialog = dialogs.remove(0);
        dialog.dispose();
    }
}