public void removeNotify() {
    super.removeNotify();
    if (okButton == null)
        return;
    setLayout(null);
    okButton.removeActionListener(this);
    okButton = null;
    for (MouseListener listener : getMouseListeners()) {
        removeMouseListener(listener);
    }
}