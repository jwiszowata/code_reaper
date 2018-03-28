public void setMapTransform(IMapTransform mt) {
    currentMapTransform = mt;
    getGUI().updateMapControls();
}