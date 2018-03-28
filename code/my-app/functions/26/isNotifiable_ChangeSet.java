public boolean isNotifiable(ServerPlayer serverPlayer) {
    switch(check(serverPlayer)) {
        case VISIBLE:
            return true;
        case INVISIBLE:
            return false;
        case SPECIAL:
            break;
    }
    if (fcgo == null)
        return false;
    if (fcgo instanceof Unit) {
        return serverPlayer.canSeeUnit((Unit) fcgo);
    }
    if (fcgo instanceof Ownable && serverPlayer.owns((Ownable) fcgo)) {
        return true;
    }
    if (fcgo instanceof WorkLocation) {
        return false;
    }
    if (fcgo instanceof Location) {
        Tile tile = ((Location) fcgo).getTile();
        return serverPlayer.canSee(tile);
    }
    return false;
}