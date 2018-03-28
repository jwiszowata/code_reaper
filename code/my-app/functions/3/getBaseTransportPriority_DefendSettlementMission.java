public int getBaseTransportPriority() {
    return (getTransportDestination() == null) ? 0 : NORMAL_TRANSPORT_PRIORITY + 5;
}