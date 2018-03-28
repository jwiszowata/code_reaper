public boolean canClaimForSettlement(Tile tile) {
    return canClaimForSettlementReason(tile) == NoClaimReason.NONE;
}