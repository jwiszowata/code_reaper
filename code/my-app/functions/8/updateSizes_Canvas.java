private void updateSizes() {
    if (oldSize == null || oldSize.width != getWidth() || oldSize.height != getHeight()) {
        gui.updateMapControlsInCanvas();
        mapViewer.setSize(getSize());
        mapViewer.forceReposition();
        oldSize = getSize();
    }
}