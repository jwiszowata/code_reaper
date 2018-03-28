public void quit() {
    if (frame != null && !windowed) {
        frame.exitFullScreen();
    }
}