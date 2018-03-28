public void zoomOutMap() {
    super.zoomOutMap();
    mapViewer.decreaseMapScale();
    refresh();
}