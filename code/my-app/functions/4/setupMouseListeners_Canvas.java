public void setupMouseListeners() {
    addMouseListener(new CanvasMouseListener(freeColClient, this));
    addMouseMotionListener(new CanvasMouseMotionListener(freeColClient, this));
}