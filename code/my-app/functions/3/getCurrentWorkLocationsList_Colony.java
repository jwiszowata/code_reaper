public List<WorkLocation> getCurrentWorkLocationsList() {
    return transform(getAllWorkLocations(), WorkLocation::isCurrent);
}