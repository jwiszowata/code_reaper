public NativeTradeAction handleTrade(NativeTradeAction action, NativeTrade nt) {
    final int HAGGLE_NUMBER = 3;
    if (nt == null || !this.getPlayer().owns(nt.getIndianSettlement())) {
        return NativeTradeAction.NAK_INVALID;
    }
    final Specification spec = getSpecification();
    final IndianSettlement is = nt.getIndianSettlement();
    final Unit unit = nt.getUnit();
    final Player other = unit.getOwner();
    final Turn turn = getGame().getTurn();
    NativeTradeItem ours;
    int anger, haggle;
    switch(action) {
        case OPEN:
            switch(is.getAlarm(other).getLevel()) {
                case HAPPY:
                case CONTENT:
                    anger = 1;
                    break;
                case DISPLEASED:
                    anger = 2;
                    break;
                case ANGRY:
                default:
                    anger = -1;
                    break;
            }
            if (anger < 0)
                return NativeTradeAction.NAK_HOSTILE;
            updateTrade(nt, anger);
            return NativeTradeAction.ACK_OPEN;
        case BUY:
            switch(is.getAlarm(other).getLevel()) {
                case HAPPY:
                case CONTENT:
                    anger = 1;
                    break;
                case DISPLEASED:
                    anger = 2;
                    break;
                case ANGRY:
                default:
                    anger = -1;
                    break;
            }
            if (anger < 0)
                return NativeTradeAction.NAK_HOSTILE;
            updateTrade(nt, anger);
            ours = find(nt.getSettlementToUnit(), nt.getItem().goodsMatcher());
            if (ours == null)
                return NativeTradeAction.NAK_INVALID;
            if (nt.getItem().priceIsSet() && nt.getItem().getPrice() >= ours.getPrice()) {
                return NativeTradeAction.ACK_BUY;
            }
            haggle = ours.getHaggleCount() + 1;
            if (randomInt(logger, "Haggle-buy", getAIRandom(), HAGGLE_NUMBER + haggle) >= HAGGLE_NUMBER) {
                return NativeTradeAction.NAK_HAGGLE;
            }
            ours.setHaggleCount(haggle);
            updateTrade(nt, anger);
            nt.setItem(ours);
            return NativeTradeAction.ACK_BUY_HAGGLE;
        case SELL:
            switch(is.getAlarm(other).getLevel()) {
                case HAPPY:
                case CONTENT:
                    anger = 1;
                    break;
                case DISPLEASED:
                    anger = 2;
                    break;
                case ANGRY:
                    anger = (any(nt.getUnitToSettlement(), nti -> nti.getGoods().getType().getMilitary())) ? 3 : -1;
                    break;
                default:
                    anger = -1;
                    break;
            }
            if (anger < 0)
                return NativeTradeAction.NAK_HOSTILE;
            updateTrade(nt, anger);
            ours = find(nt.getUnitToSettlement(), nt.getItem().goodsMatcher());
            if (ours == null)
                return NativeTradeAction.NAK_INVALID;
            if (nt.getItem().priceIsSet() && nt.getItem().getPrice() <= ours.getPrice()) {
                return NativeTradeAction.ACK_SELL;
            }
            haggle = ours.getHaggleCount() + 1;
            if (randomInt(logger, "Haggle-sell", getAIRandom(), HAGGLE_NUMBER + haggle) >= HAGGLE_NUMBER) {
                return NativeTradeAction.NAK_HAGGLE;
            }
            ours.setHaggleCount(haggle);
            updateTrade(nt, anger);
            nt.setItem(ours);
            return NativeTradeAction.ACK_SELL_HAGGLE;
        case GIFT:
            ours = find(nt.getUnitToSettlement(), nt.getItem().goodsMatcher());
            if (ours == null)
                return NativeTradeAction.NAK_INVALID;
            return (is.canAdd(nt.getItem().getGoods())) ? NativeTradeAction.ACK_GIFT : NativeTradeAction.NAK_GOODS;
        default:
            return NativeTradeAction.NAK_INVALID;
    }
}