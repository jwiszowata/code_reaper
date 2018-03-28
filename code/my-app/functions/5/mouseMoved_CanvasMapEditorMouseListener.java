public void mouseMoved(MouseEvent e) {
    if (getMap() == null)
        return;
    performAutoScrollIfActive(e, true);
}