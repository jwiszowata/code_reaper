public TileImprovement addRoad() {
    TileImprovementType roadType = getSpecification().getTileImprovementType("model.improvement.road");
    TileImprovement road = new TileImprovement(getGame(), this, roadType, null);
    road.setMagnitude(1);
    return (addTileItem(road)) ? road : null;
}