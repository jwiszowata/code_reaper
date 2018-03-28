public void showMapEditorTransformPanel() {
    JInternalFrame f = addAsFrame(new MapEditorTransformPanel(freeColClient), true, PopupPosition.CENTERED, false);
    f.setLocation(f.getX(), 50);
    repaint();
}