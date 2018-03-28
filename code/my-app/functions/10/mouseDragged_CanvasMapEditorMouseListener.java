public void mouseDragged(MouseEvent e) {
    if (getMap() == null)
        return;
    final JComponent component = (JComponent) e.getSource();
    drawBox(component, startPoint, endPoint);
    endPoint = e.getPoint();
    drawBox(component, startPoint, endPoint);
    performDragScrollIfActive(e);
    getGUI().refresh();
}