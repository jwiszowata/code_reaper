public Stream<FreeColGameObject> getDisposables() {
    return concat(flatten(getAllWorkLocations(), WorkLocation::getDisposables), super.getDisposables());
}