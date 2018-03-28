public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (pioneer != null) {
        result = Math.min(result, pioneer.checkIntegrity(fix));
    }
    if (type == null || target == null)
        result = -1;
    return result;
}