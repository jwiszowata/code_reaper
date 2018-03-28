public void reset() {
    keyStroke = getOption().getAccelerator();
    bl.setText(getHumanKeyStrokeText(keyStroke));
}