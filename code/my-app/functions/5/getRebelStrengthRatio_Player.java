public double getRebelStrengthRatio(boolean naval) {
    if (getPlayerType() != PlayerType.COLONIAL)
        return 0.0;
    return strengthRatio(calculateStrength(naval), getMonarch().getExpeditionaryForce().calculateStrength(naval));
}