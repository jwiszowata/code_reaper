public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (this.tile == null) {
        logger.warning("Tile item with no tile: " + this.getId());
        return -1;
    }
    return result;
}