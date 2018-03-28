public void updateMenuBar() {
    JMenuBar menuBar = getJMenuBar();
    if (menuBar != null) {
        ((FreeColMenuBar) menuBar).update();
    }
}