public boolean csFlushMarket(ChangeSet cs) {
    Market market = getMarket();
    if (market == null)
        return false;
    final Specification spec = getSpecification();
    boolean ret = false;
    StringBuilder sb = new StringBuilder(32);
    sb.append("Flush market for ").append(getId()).append(':');
    for (GoodsType goodsType : transform(spec.getGoodsTypeList(), gt -> csFlushMarket(gt, cs))) {
        sb.append(' ').append(goodsType.getId());
        ret = true;
    }
    if (ret)
        logger.finest(sb.toString());
    return ret;
}