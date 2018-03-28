public void changeWindowedMode() {
    JMenuBar menuBar = null;
    Rectangle windowBounds = null;
    if (frame != null) {
        menuBar = frame.getJMenuBar();
        if (windowed) {
            windowBounds = frame.getBounds();
        }
        frame.setVisible(false);
        frame.dispose();
    }
    windowed = !windowed;
    createFrame(menuBar, windowBounds);
}