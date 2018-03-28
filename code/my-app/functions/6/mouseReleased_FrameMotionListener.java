public void mouseReleased(MouseEvent e) {
    if (loc == null || f.getDesktopPane() == null || f.getDesktopPane().getDesktopManager() == null) {
        return;
    }
    f.getDesktopPane().getDesktopManager().endDraggingFrame(f);
}