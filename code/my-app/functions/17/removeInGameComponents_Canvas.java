public void removeInGameComponents() {
    KeyListener[] keyListeners = getKeyListeners();
    for (KeyListener keyListener : keyListeners) {
        removeKeyListener(keyListener);
    }
    MouseListener[] mouseListeners = getMouseListeners();
    for (MouseListener mouseListener : mouseListeners) {
        removeMouseListener(mouseListener);
    }
    MouseMotionListener[] mouseMotionListeners = getMouseMotionListeners();
    for (MouseMotionListener mouseMotionListener : mouseMotionListeners) {
        removeMouseMotionListener(mouseMotionListener);
    }
    for (Component c : getComponents()) {
        removeFromCanvas(c);
    }
}