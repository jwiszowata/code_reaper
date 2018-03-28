protected final boolean unregister(String name, DOMClientNetworkRequestHandler handler) {
    return this.domHandlerMap.remove(name, handler);
}