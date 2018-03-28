public void actionPerformed(ActionEvent ae) {
    if (!hasFocus())
        stopBlinking();
    if (blinkOn) {
        setOpaque(false);
        blinkOn = false;
        repaint();
    } else {
        setOpaque(true);
        setBackground(Color.RED);
        blinkOn = true;
        repaint();
    }
}