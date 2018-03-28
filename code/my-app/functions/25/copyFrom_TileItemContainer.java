public void copyFrom(TileItemContainer tic, Layer layer) {
    final Specification spec = getSpecification();
    final Game game = getGame();
    List<TileItem> otherItems = tic.getTileItems();
    List<TileItem> result = new ArrayList<TileItem>();
    for (TileItem item : transform(otherItems, ti -> layer.compareTo(ti.getLayer()) >= 0)) {
        if (item instanceof Resource) {
            Resource resource = (Resource) item;
            ResourceType type = spec.getResourceType(resource.getType().getId());
            result.add(new Resource(game, tile, type, resource.getQuantity()));
        } else if (item instanceof LostCityRumour) {
            LostCityRumour rumour = (LostCityRumour) item;
            result.add(new LostCityRumour(game, tile, rumour.getType(), rumour.getName()));
        } else if (item instanceof TileImprovement) {
            TileImprovement improvement = (TileImprovement) item;
            if (layer.compareTo(Map.Layer.ALL) >= 0 || improvement.getType().isNatural()) {
                TileImprovementType type = spec.getTileImprovementType(improvement.getType().getId());
                result.add(new TileImprovement(game, tile, type, improvement.getStyle()));
            }
        } else {
            logger.warning("Bogus tile item: " + item.getId());
        }
    }
    setTileItems(result);
}