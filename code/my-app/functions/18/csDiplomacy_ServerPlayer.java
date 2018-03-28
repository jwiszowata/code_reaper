public void csDiplomacy(DiplomacySession session, DiplomaticTrade agreement, ChangeSet cs) {
    agreement.incrementVersion();
    TradeStatus status = agreement.getStatus();
    switch(status) {
        case PROPOSE_TRADE:
            session.setAgreement(agreement);
            ServerPlayer otherPlayer = session.getOtherPlayer(this);
            cs.add(See.only(otherPlayer), session.getMessage(otherPlayer));
            break;
        case ACCEPT_TRADE:
            session.complete(true, cs);
            break;
        case REJECT_TRADE:
        default:
            session.complete(false, cs);
            break;
    }
}