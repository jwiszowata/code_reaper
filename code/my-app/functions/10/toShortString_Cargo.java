public String toShortString() {
    LogBuilder lb = new LogBuilder(32);
    lb.add(getModeString(), " ", transportable);
    Location lt = getTransportTarget();
    lb.add(" @ ", ((lt == null) ? "null" : lt.toShortString()));
    Location ct = getCarrierTarget();
    if (ct != lt)
        lb.add("/", ((ct == null) ? "null" : ct.toShortString()));
    return lb.toString();
}