void increaseMapScale() {
    float newScale = lib.getScaleFactor() + MAP_SCALE_STEP;
    if (newScale >= MAP_SCALE_MAX)
        newScale = MAP_SCALE_MAX;
    setImageLibraryAndUpdateData(new ImageLibrary(newScale));
    updateMapDisplayVariables();
}