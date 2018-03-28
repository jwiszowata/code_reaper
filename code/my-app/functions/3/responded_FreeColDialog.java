public synchronized boolean responded() {
    return this.pane != null && this.pane.getValue() != JOptionPane.UNINITIALIZED_VALUE;
}