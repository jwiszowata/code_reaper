public FreeColGameObject getFreeColGameObject(String id) {
    if (id == null || id.isEmpty())
        return null;
    final WeakReference<FreeColGameObject> ro;
    synchronized (freeColGameObjects) {
        ro = freeColGameObjects.get(id);
    }
    if (ro == null)
        return null;
    final FreeColGameObject o = ro.get();
    if (o == null) {
        removeFreeColGameObject(id, "missed");
        return null;
    }
    return o;
}