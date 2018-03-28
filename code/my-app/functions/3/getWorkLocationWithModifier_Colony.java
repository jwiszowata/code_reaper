public WorkLocation getWorkLocationWithModifier(String modifier) {
    return find(getCurrentWorkLocations(), wl -> wl.hasModifier(modifier));
}