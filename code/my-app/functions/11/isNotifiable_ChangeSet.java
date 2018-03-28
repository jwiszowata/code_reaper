public boolean isNotifiable(ServerPlayer serverPlayer) {
    switch(check(serverPlayer)) {
        case VISIBLE:
            return true;
        case INVISIBLE:
            return false;
        case SPECIAL:
            break;
    }
    return seeOld(serverPlayer) || seeNew(serverPlayer);
}