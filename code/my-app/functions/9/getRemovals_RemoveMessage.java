public List<FreeColGameObject> getRemovals(Game game) {
    List<FreeColGameObject> ret = new ArrayList<>();
    for (String id : getArrayAttributes()) {
        FreeColGameObject fcgo = game.getFreeColGameObject(id);
        if (fcgo != null)
            ret.add(fcgo);
    }
    return ret;
}