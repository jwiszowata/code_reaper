protected final boolean unregister(String name, DOMNetworkRequestHandler handler) {
    return this.handlerMap.remove(name, handler);
}