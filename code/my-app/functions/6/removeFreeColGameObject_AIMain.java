public void removeFreeColGameObject(String id) {
    AIObject o = getAIObject(id);
    if (o != null)
        o.dispose();
    removeAIObject(id);
}