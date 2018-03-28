private void focus(MouseEvent e) {
    if (e.getComponent().isEnabled()) {
        focus(e.getX(), e.getY());
    }
}