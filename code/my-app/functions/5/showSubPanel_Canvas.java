private void showSubPanel(FreeColPanel panel, PopupPosition popupPosition, boolean resizable) {
    repaint();
    addAsFrame(panel, false, popupPosition, resizable);
    panel.requestFocus();
}