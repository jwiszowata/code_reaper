public TileImprovement getRiver() {
    return (TileImprovement) findTileItem(ti -> ti instanceof TileImprovement && ((TileImprovement) ti).isRiver());
}