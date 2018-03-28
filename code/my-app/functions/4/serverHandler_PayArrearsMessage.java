public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final GoodsType goodsType = freeColServer.getSpecification().getGoodsType(getStringAttribute(GOODS_TYPE_TAG));
    return freeColServer.getInGameController().payArrears(serverPlayer, goodsType);
}