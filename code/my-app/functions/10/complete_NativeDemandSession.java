protected boolean complete(boolean result) {
    ChangeSet cs = new ChangeSet();
    boolean ret = super.complete(cs);
    if (!ret) {
        completeInternal(result, cs);
        cs.add(See.only(getColonyOwner()), TrivialMessage.CLOSE_MENUS_MESSAGE);
        getGame().sendToAll(cs);
    }
    return ret;
}