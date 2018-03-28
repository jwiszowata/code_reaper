public void removeFreeColGameObject(String id, String reason) {
    if (id == null)
        throw new IllegalArgumentException("Null identifier.");
    if (id.isEmpty())
        throw new IllegalArgumentException("Empty identifier.");
    logger.finest("removeFCGO/" + reason + ": " + id);
    notifyRemoveFreeColGameObject(id);
    synchronized (freeColGameObjects) {
        freeColGameObjects.remove(id);
    }
    if (++removeCount > REMOVE_GC_THRESHOLD) {
        synchronized (freeColGameObjects) {
            Iterator<FreeColGameObject> iter = getFreeColGameObjectIterator();
            while (iter.hasNext()) iter.next();
        }
        removeCount = 0;
        System.gc();
    }
}