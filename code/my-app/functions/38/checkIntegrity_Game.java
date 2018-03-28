public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    LogBuilder lb = new LogBuilder(512);
    lb.add("Uninitialized game ids: ");
    lb.mark();
    synchronized (freeColGameObjects) {
        Iterator<FreeColGameObject> iterator = getFreeColGameObjectIterator();
        while (iterator.hasNext()) {
            FreeColGameObject fcgo = iterator.next();
            if (fcgo == null) {
                lb.add(" null-fcgo");
            } else if (!fcgo.isInitialized()) {
                lb.add(" ", fcgo.getId(), "(", lastPart(fcgo.getClass().getName(), "."), ")");
            } else {
                continue;
            }
            if (fix) {
                iterator.remove();
                result = Math.min(result, 0);
            } else {
                result = -1;
            }
        }
    }
    if (lb.grew()) {
        if (fix)
            lb.add(" (dropped)");
        lb.log(logger, Level.WARNING);
    }
    Map map = getMap();
    if (map != null) {
        result = Math.min(result, getMap().checkIntegrity(fix));
    }
    for (Player player : getPlayerList()) {
        result = Math.min(result, player.checkIntegrity(fix));
    }
    return result;
}