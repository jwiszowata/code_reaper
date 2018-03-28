protected boolean complete(boolean result) {
    ChangeSet cs = new ChangeSet();
    boolean ret = complete(false, cs);
    if (!ret) {
        cs.add(See.only((ServerPlayer) this.agreement.getSender()), TrivialMessage.CLOSE_MENUS_MESSAGE);
        cs.add(See.only((ServerPlayer) this.agreement.getRecipient()), TrivialMessage.CLOSE_MENUS_MESSAGE);
    }
    getGame().sendToAll(cs);
    return ret;
}