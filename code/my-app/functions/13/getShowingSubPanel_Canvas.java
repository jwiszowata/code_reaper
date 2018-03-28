public Component getShowingSubPanel() {
    for (Component c : getComponents()) {
        if (c instanceof ToolBoxFrame) {
            continue;
        }
        if (c instanceof JInternalFrame) {
            return c;
        } else if (c instanceof JInternalFrame.JDesktopIcon) {
            return c;
        }
    }
    return null;
}