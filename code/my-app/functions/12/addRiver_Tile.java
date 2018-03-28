public TileImprovement addRiver(int magnitude, String conns) {
    if (magnitude == TileImprovement.NO_RIVER)
        return null;
    TileImprovementType riverType = getSpecification().getTileImprovementType("model.improvement.river");
    TileImprovement river = new TileImprovement(getGame(), this, riverType, null);
    river.setTurnsToComplete(0);
    river.setMagnitude(magnitude);
    if (!addTileItem(river))
        return null;
    river.updateRiverConnections(conns);
    return river;
}