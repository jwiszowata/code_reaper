public void keyReleased(KeyEvent e) {
    KeyStroke ks = KeyStroke.getKeyStroke(e.getKeyCode(), e.getModifiers());
    if (FreeColActionUI.this.optionGroupUI != null) {
        FreeColActionUI.this.optionGroupUI.removeKeyStroke(ks);
    }
    keyStroke = ks;
    stopBlinking();
    setText(getHumanKeyStrokeText(keyStroke));
    recordButton.requestFocus();
}