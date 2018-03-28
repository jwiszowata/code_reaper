public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    for (Unit unit : getUnitList()) {
        if (unit.getOwner() == null) {
            if (fix) {
                unit.setOwner(this);
                logger.warning("Fixed missing owner for: " + unit.getId());
                result = 0;
            } else {
                logger.warning("Missing owner for: " + unit.getId());
                result = -1;
            }
        }
        result = Math.min(result, unit.checkIntegrity(fix));
    }
    if (monarch != null) {
        result = Math.min(result, monarch.checkIntegrity(fix));
    }
    return result;
}