public TileImprovement removeRoad() {
    TileImprovement road = getRoad();
    if (road == null)
        return null;
    road.updateRoadConnections(false);
    return removeTileItem(road);
}