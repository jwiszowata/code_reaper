private static String invalidSettlementReason(AIUnit aiUnit, Settlement settlement) {
    return invalidTargetReason(settlement, aiUnit.getUnit().getOwner());
}