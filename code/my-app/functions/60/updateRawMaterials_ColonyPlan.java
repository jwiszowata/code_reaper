private void updateRawMaterials(Map<GoodsType, Map<WorkLocation, Integer>> production) {
    Player player = colony.getOwner();
    Market market = player.getMarket();
    NationType nationType = player.getNationType();
    GoodsType primaryRawMaterial = null;
    GoodsType secondaryRawMaterial = null;
    int primaryValue = -1;
    int secondaryValue = -1;
    produce.clear();
    List<GoodsType> rawMaterials = new ArrayList<>(rawLuxuryGoodsTypes);
    rawMaterials.addAll(otherRawGoodsTypes);
    for (GoodsType g : rawMaterials) {
        int value = sum(production.get(g).entrySet(), Entry::getValue);
        if (value <= LOW_PRODUCTION_THRESHOLD) {
            production.remove(g);
            continue;
        }
        if (market != null) {
            if (g.getOutputType() == null) {
                value *= market.getSalePrice(g, 1);
            } else if (production.containsKey(g.getOutputType())) {
                value *= (market.getSalePrice(g, 1) + market.getSalePrice(g.getOutputType(), 1)) / 2;
            }
        }
        if (nationType.hasModifier(g.getId())) {
            value = (value * 12) / 10;
        }
        if (value > secondaryValue && secondaryRawMaterial != null) {
            production.remove(secondaryRawMaterial);
            production.remove(secondaryRawMaterial.getOutputType());
            if (rawLuxuryGoodsTypes.contains(secondaryRawMaterial)) {
                rawLuxuryGoodsTypes.remove(secondaryRawMaterial);
                luxuryGoodsTypes.remove(secondaryRawMaterial.getOutputType());
            } else if (otherRawGoodsTypes.contains(secondaryRawMaterial)) {
                otherRawGoodsTypes.remove(secondaryRawMaterial);
            }
        }
        if (value > primaryValue) {
            secondaryRawMaterial = primaryRawMaterial;
            secondaryValue = primaryValue;
            primaryRawMaterial = g;
            primaryValue = value;
        } else if (value > secondaryValue) {
            secondaryRawMaterial = g;
            secondaryValue = value;
        }
    }
    if (primaryRawMaterial != null) {
        produce.add(primaryRawMaterial);
        if (primaryRawMaterial.getOutputType() != null) {
            produce.add(primaryRawMaterial.getOutputType());
        }
        if (secondaryRawMaterial != null) {
            produce.add(secondaryRawMaterial);
            if (secondaryRawMaterial.getOutputType() != null) {
                produce.add(secondaryRawMaterial.getOutputType());
            }
        }
    }
}