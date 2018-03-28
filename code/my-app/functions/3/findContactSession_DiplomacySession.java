public static DiplomacySession findContactSession(Unit unit, Settlement settlement) {
    return findContactSession(unit.getOwner(), settlement.getOwner());
}