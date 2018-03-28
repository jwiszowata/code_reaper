public void updateMapControlsInCanvas() {
    if (mapControls == null)
        return;
    mapControls.removeFromComponent(canvas);
    mapControls.addToComponent(canvas);
}