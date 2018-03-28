private static FreeColObject getDefaultDisplay(MessageType messageType, FreeColGameObject source) {
    FreeColObject o = null;
    switch(messageType) {
        case SONS_OF_LIBERTY:
        case GOVERNMENT_EFFICIENCY:
            o = source.getSpecification().getGoodsType("model.goods.bells");
            break;
        case UNIT_IMPROVED:
        case UNIT_DEMOTED:
        case UNIT_LOST:
        case UNIT_ADDED:
        case LOST_CITY_RUMOUR:
        case COMBAT_RESULT:
        case DEMANDS:
        case GOODS_MOVEMENT:
            o = source;
            break;
        case BUILDING_COMPLETED:
            o = source.getSpecification().getGoodsType("model.goods.hammers");
            break;
        case DEFAULT:
        case WARNING:
        case WAREHOUSE_CAPACITY:
        case FOREIGN_DIPLOMACY:
        case MARKET_PRICES:
        case MISSING_GOODS:
        case TUTORIAL:
        case GIFT_GOODS:
        default:
            if (source instanceof Player)
                o = source;
            break;
    }
    return o;
}