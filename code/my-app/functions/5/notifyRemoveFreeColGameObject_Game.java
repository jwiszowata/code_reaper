public void notifyRemoveFreeColGameObject(String id) {
    if (freeColGameObjectListener != null) {
        freeColGameObjectListener.removeFreeColGameObject(id);
    }
}