public Boolean indianDemand(Unit unit, Colony colony, GoodsType goods, int gold, Boolean accept) {
    return !"conquest".equals(getAIAdvantage());
}