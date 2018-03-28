public boolean claimTransportable(TransportableAIObject t) {
    return transportSupply.remove(t);
}