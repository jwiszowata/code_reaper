public ServerState getState() {
    return getEnumAttribute(STATE_TAG, ServerState.class, (ServerState) null);
}