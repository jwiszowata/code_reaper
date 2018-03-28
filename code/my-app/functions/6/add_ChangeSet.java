public ChangeSet add(See see, Collection<? extends FreeColGameObject> objects) {
    for (FreeColGameObject o : objects) {
        changes.add(new ObjectChange(see, o));
    }
    return this;
}