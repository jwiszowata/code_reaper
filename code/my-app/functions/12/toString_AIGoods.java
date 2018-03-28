public String toString() {
    LogBuilder lb = new LogBuilder(64);
    lb.add("[", getId(), " ", goods);
    if (goods != null)
        lb.add(" at ", goods.getLocation());
    lb.add(" -> ", destination);
    AIUnit transport = getTransport();
    if (transport != null)
        lb.add(" using ", transport.getUnit());
    lb.add("/", getTransportPriority(), "]");
    return lb.toString();
}