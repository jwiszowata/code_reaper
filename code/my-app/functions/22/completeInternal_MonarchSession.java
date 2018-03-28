private void completeInternal(Boolean result, ChangeSet cs) {
    switch(action) {
        case RAISE_TAX_ACT:
        case RAISE_TAX_WAR:
            if (result == null) {
                serverPlayer.ignoreTax(tax, goods, cs);
            } else {
                serverPlayer.csRaiseTax(tax, goods, result, cs);
            }
            break;
        case MONARCH_MERCENARIES:
        case HESSIAN_MERCENARIES:
            if (result == null) {
                serverPlayer.ignoreMercenaries(cs);
            } else if (result) {
                serverPlayer.csAddMercenaries(mercenaries, price, cs);
            }
            break;
        default:
            break;
    }
}