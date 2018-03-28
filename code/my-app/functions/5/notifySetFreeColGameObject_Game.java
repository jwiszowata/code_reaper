public void notifySetFreeColGameObject(String id, FreeColGameObject fcgo) {
    if (freeColGameObjectListener != null) {
        freeColGameObjectListener.setFreeColGameObject(id, fcgo);
    }
}