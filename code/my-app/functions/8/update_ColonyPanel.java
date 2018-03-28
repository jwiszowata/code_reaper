public void update() {
    for (Component component : getComponents()) {
        if (component instanceof ASingleTilePanel) {
            ((ASingleTilePanel) component).update();
        }
    }
    repaint();
}