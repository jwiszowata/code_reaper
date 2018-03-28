public void keyTyped(KeyEvent e) {
    if (e.getKeyChar() == KeyEvent.VK_DELETE) {
        deleteCurrentlySelectedStops();
    }
}