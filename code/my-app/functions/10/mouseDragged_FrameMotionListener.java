public void mouseDragged(MouseEvent e) {
    if (loc == null || f.getDesktopPane() == null || f.getDesktopPane().getDesktopManager() == null) {
        return;
    }
    Point p = SwingUtilities.convertPoint((Component) e.getSource(), e.getX(), e.getY(), null);
    int moveX = loc.x - p.x;
    int moveY = loc.y - p.y;
    f.getDesktopPane().getDesktopManager().dragFrame(f, f.getX() - moveX, f.getY() - moveY);
    loc = p;
}