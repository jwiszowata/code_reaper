private void notifyClose(Component c, JInternalFrame frame) {
    if (frame == null)
        return;
    if (c instanceof FreeColPanel) {
        FreeColPanel fcp = (FreeColPanel) c;
        fcp.firePropertyChange("closing", false, true);
        savePosition(fcp, frame.getLocation());
        saveSize(fcp, fcp.getSize());
    }
}