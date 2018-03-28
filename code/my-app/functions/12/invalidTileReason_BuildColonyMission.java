private static String invalidTileReason(AIUnit aiUnit, Tile tile) {
    Player owner = aiUnit.getUnit().getOwner();
    Player.NoClaimReason reason = owner.canClaimToFoundSettlementReason(tile);
    switch(reason) {
        case NONE:
        case NATIVES:
            return null;
        default:
            break;
    }
    return "target-" + reason;
}