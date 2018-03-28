public <T extends WorkLocation> T getWorkLocationWithModifier(String modifier, Class<T> returnClass) {
    WorkLocation wl = getWorkLocationWithModifier(modifier);
    if (wl != null)
        try {
            return returnClass.cast(wl);
        } catch (ClassCastException cce) {
        }
    return null;
}