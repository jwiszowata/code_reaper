public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (colony == null || colony.isDisposed())
        result = -1;
    return result;
}