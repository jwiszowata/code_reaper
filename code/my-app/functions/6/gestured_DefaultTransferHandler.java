void gestured(JComponent c, MouseEvent e, int srcActions, int action) {
    setComponent(c);
    setSourceActions(srcActions);
    appendEvent(e);
    fireDragGestureRecognized(action, e.getPoint());
}