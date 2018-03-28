public void stopBlinking() {
    blinkingTimer.stop();
    setOpaque(false);
    repaint();
}