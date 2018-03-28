public void findNewObjects(boolean overwrite) {
    for (FreeColGameObject fcgo : freeColServer.getGame().getFreeColGameObjectList()) {
        if (!shouldHaveAIObject(fcgo))
            continue;
        if (overwrite || getAIObject(fcgo) == null) {
            setFreeColGameObject(fcgo.getId(), fcgo);
        }
    }
}