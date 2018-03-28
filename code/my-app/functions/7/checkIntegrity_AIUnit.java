public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (unit == null || unit.isDisposed()) {
        result = -1;
    }
    return result;
}