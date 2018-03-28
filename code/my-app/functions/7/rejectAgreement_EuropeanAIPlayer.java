private TradeStatus rejectAgreement(TradeItem stance, DiplomaticTrade agreement) {
    if (stance == null)
        return TradeStatus.REJECT_TRADE;
    agreement.clear();
    agreement.add(stance);
    return TradeStatus.PROPOSE_TRADE;
}