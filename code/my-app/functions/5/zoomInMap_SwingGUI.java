public void zoomInMap() {
    super.zoomInMap();
    mapViewer.increaseMapScale();
    refresh();
}