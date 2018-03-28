public boolean containsInGameComponents() {
    KeyListener[] keyListeners = getKeyListeners();
    if (keyListeners.length > 0) {
        return true;
    }
    MouseListener[] mouseListeners = getMouseListeners();
    if (mouseListeners.length > 0) {
        return true;
    }
    MouseMotionListener[] mouseMotionListeners = getMouseMotionListeners();
    if (mouseMotionListeners.length > 0) {
        return true;
    }
    return false;
}