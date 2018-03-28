public void cleanup() {
    removeMouseListener(pressListener);
    removeMouseListener(releaseListener);
    setTransferHandler(null);
    removePropertyChangeListeners();
    removeAll();
}