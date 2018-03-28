private void dropExportGoods(AIGoods ag) {
    AIUnit transport = ag.getTransport();
    if (transport != null)
        transport.removeTransportable(ag);
    removeExportGoods(ag);
    ag.dispose();
}