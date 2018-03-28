public TileImprovement getRoad() {
    return (TileImprovement) findTileItem(ti -> ti instanceof TileImprovement && ((TileImprovement) ti).isRoad());
}