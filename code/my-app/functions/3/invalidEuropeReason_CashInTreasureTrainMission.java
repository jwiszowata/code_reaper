private static String invalidEuropeReason(AIUnit aiUnit, Europe europe) {
    return invalidTargetReason(europe, aiUnit.getUnit().getOwner());
}