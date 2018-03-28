public void cleanup() {
    if (colony != null) {
        colony.removePropertyChangeListener(EVENT, this);
    }
    for (MouseListener listener : getMouseListeners()) {
        removeMouseListener(listener);
    }
}