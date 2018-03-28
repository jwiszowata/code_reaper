public void divert(FreeColGameObject newSource) {
    if (Utils.equals(displayId, sourceId))
        displayId = newSource.getId();
    sourceId = newSource.getId();
}