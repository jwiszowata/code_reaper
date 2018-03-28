public final Resource getResource() {
    return (Resource) findTileItem(ti -> ti instanceof Resource);
}