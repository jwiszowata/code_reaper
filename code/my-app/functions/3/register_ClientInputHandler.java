protected final void register(String name, DOMClientNetworkRequestHandler handler) {
    this.domHandlerMap.put(name, handler);
}