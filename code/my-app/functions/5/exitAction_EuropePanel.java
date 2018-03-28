private void exitAction() {
    cleanup();
    getGUI().removeFromCanvas(this);
    igc().nextModelMessage();
}