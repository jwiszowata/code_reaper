public void cleanup() {
    for (Component component : getComponents()) {
        if (component instanceof ASingleTilePanel) {
            ((ASingleTilePanel) component).cleanup();
        }
    }
    removeAll();
}