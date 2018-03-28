protected Boolean goodSuggestionCheck(UnitType unitType, Unit unit, GoodsType goodsType) {
    final Tile tile = getWorkTile();
    final Player owner = getOwner();
    return owner.owns(tile) || owner.canClaimForSettlement(tile);
}