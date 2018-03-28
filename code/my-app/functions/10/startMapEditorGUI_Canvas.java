public void startMapEditorGUI() {
    if (frame == null)
        return;
    gui.resetMapZoom();
    frame.setMapEditorMenuBar();
    showMapEditorTransformPanel();
    CanvasMapEditorMouseListener listener = new CanvasMapEditorMouseListener(freeColClient, this);
    addMouseListener(listener);
    addMouseMotionListener(listener);
}