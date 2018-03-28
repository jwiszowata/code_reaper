public ChangeSet addRemoves(See see, Location loc, List<? extends FreeColGameObject> objects) {
    for (FreeColGameObject fcgo : objects) {
        changes.add(new RemoveChange(see, loc, fcgo.getDisposables()));
    }
    return this;
}