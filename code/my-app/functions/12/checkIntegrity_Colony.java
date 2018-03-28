public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (!isLandLocked() && !hasAbility(Ability.HAS_PORT)) {
        if (fix) {
            addPortAbility();
            result = Math.min(result, 0);
        } else {
            result = -1;
        }
    }
    return Math.min(result, checkBuildQueueIntegrity(fix));
}