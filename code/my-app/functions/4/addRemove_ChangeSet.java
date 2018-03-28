public ChangeSet addRemove(See see, Location loc, FreeColGameObject obj) {
    changes.add(new RemoveChange(see, loc, obj.getDisposables()));
    return this;
}