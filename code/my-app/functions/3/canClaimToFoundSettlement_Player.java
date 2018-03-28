public boolean canClaimToFoundSettlement(Tile tile) {
    return canClaimToFoundSettlementReason(tile) == NoClaimReason.NONE;
}