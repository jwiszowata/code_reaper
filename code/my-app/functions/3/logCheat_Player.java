public void logCheat(String what) {
    logger.finest("CHEAT: " + getGame().getTurn().getNumber() + " " + lastPart(getNationId(), ".") + " " + what);
}