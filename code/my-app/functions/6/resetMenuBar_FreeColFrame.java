public void resetMenuBar() {
    JMenuBar menuBar = getJMenuBar();
    if (menuBar != null) {
        ((FreeColMenuBar) menuBar).reset();
    }
}