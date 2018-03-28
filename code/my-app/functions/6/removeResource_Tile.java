public Resource removeResource() {
    Resource resource = getResource();
    if (resource == null)
        return null;
    return removeTileItem(resource);
}