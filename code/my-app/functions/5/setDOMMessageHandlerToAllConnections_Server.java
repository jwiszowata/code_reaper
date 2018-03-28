public void setDOMMessageHandlerToAllConnections(DOMMessageHandler mh) {
    for (Connection c : this.connections.values()) {
        c.setDOMMessageHandler(mh);
    }
}