public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (transportable != null) {
        result = Math.min(result, transportable.checkIntegrity(fix));
    }
    if (destination == null || ((FreeColGameObject) destination).isDisposed()) {
        result = -1;
    }
    return result;
}