public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (player == null || player.isDisposed() || !player.isAI()) {
        result = -1;
    }
    return result;
}