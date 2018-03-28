public List<WorkLocation> getAvailableWorkLocationsList() {
    return transform(getAllWorkLocations(), WorkLocation::isAvailable);
}