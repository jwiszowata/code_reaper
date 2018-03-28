private static String invalidColonyReason(AIUnit aiUnit, Colony colony) {
    return invalidTargetReason(colony, aiUnit.getUnit().getOwner());
}