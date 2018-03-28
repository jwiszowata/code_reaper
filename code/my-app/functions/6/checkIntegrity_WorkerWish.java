public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (unitType == null)
        result = -1;
    return result;
}