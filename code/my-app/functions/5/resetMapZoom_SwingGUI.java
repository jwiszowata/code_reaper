protected void resetMapZoom() {
    super.resetMapZoom();
    mapViewer.resetMapScale();
    refresh();
}