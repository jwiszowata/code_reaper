public <T extends FreeColGameObject> T getOurFreeColGameObject(String id, Class<T> returnClass) {
    T t = getGame().getFreeColGameObject(id, returnClass);
    if (t == null) {
        FreeColGameObject fcgo = getGame().getFreeColGameObject(id);
        throw new RuntimeException("Not a " + returnClass.getName() + ": " + id + "/" + fcgo);
    } else if (t instanceof Ownable) {
        if (!owns((Ownable) t)) {
            throw new IllegalStateException(returnClass.getName() + " not owned by " + getId() + ": " + id + "/" + t);
        }
    } else {
        throw new RuntimeException("Not ownable: " + id + "/" + t);
    }
    return t;
}