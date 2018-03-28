public void remove(Component comp) {
    removeFromCanvas(comp);
    gui.updateMenuBar();
    if (comp != statusPanel && !isShowingSubPanel()) {
        requestFocus();
    }
}