public int getTransportFee() {
    if (!isInEurope() && getOwner().getEurope() != null) {
        float fee = (getSpecification().getInteger(GameOptions.TREASURE_TRANSPORT_FEE) * getTreasureAmount()) / 100.0f;
        return (int) getOwner().applyModifiers(fee, getGame().getTurn(), Modifier.TREASURE_TRANSPORT_FEE, unitType);
    }
    return 0;
}