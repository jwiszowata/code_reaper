public GoodsType getType(Game game) {
    String typeId = getStringAttribute(TYPE_TAG);
    return (typeId == null) ? null : game.getSpecification().getGoodsType(typeId);
}