public List<FreeColGameObject> getFreeColGameObjectList() {
    List<FreeColGameObject> ret = new ArrayList<>();
    synchronized (freeColGameObjects) {
        Iterator<FreeColGameObject> iter = getFreeColGameObjectIterator();
        while (iter.hasNext()) ret.add(iter.next());
    }
    return ret;
}