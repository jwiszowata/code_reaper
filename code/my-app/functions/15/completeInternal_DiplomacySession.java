private void completeInternal(boolean result, ChangeSet cs) {
    logger.info("Completing diplomacy session: " + this);
    if (this.agreement != null) {
        if (result) {
            result = getGame().csAcceptTrade(this.agreement, this.unit, this.settlement, cs);
        }
        this.agreement.setStatus((result) ? TradeStatus.ACCEPT_TRADE : TradeStatus.REJECT_TRADE);
        ServerPlayer sp = (ServerPlayer) this.agreement.getSender();
        cs.add(See.only(sp), getMessage(sp));
        sp = (ServerPlayer) this.agreement.getRecipient();
        cs.add(See.only(sp), getMessage(sp));
    }
    this.unit.setMovesLeft(0);
    cs.add(See.only(getOwner()), this.unit);
}