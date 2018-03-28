public void removeNotify() {
    super.removeNotify();
    getGUI().dialogRemove(FreeColDialog.this);
    removeAll();
    if (this.pane != null) {
        this.pane.removePropertyChangeListener(this);
        this.pane = null;
    }
    for (MouseListener listener : getMouseListeners()) {
        removeMouseListener(listener);
    }
}