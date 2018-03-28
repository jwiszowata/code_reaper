public void update() {
    super.update();
    getGUI().enableMapControls(isEnabled() && isSelected());
}