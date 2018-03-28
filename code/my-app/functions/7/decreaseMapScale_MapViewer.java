void decreaseMapScale() {
    float newScale = lib.getScaleFactor() - MAP_SCALE_STEP;
    if (newScale <= MAP_SCALE_MIN)
        newScale = MAP_SCALE_MIN;
    setImageLibraryAndUpdateData(new ImageLibrary(newScale));
    updateMapDisplayVariables();
}