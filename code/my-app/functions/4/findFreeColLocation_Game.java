public Location findFreeColLocation(String id) {
    FreeColGameObject fcgo = getFreeColGameObject(id);
    return (fcgo instanceof Location) ? (Location) fcgo : null;
}