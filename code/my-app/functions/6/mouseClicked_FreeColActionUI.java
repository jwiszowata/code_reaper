public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() > 1) {
        startBlinking();
        requestFocus();
    }
}