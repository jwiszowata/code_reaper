public ChangeSet addDisappear(ServerPlayer owner, Tile tile, FreeColGameObject fcgo) {
    changes.add(new RemoveChange(See.perhaps().except(owner), tile, Stream.of(fcgo)));
    changes.add(new ObjectChange(See.perhaps().except(owner), tile));
    return this;
}