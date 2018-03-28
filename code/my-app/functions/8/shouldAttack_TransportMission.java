private boolean shouldAttack(Unit other) {
    if (invalidAttackReason(getAIUnit(), other.getOwner()) != null)
        return false;
    final Unit carrier = getUnit();
    final CombatModel cm = getGame().getCombatModel();
    double offence = cm.getOffencePower(carrier, other) * ((carrier.hasCargo()) ? 0.3 : 0.80);
    return offence > cm.getOffencePower(other, carrier);
}