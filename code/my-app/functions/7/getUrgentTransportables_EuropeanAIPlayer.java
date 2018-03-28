public List<TransportableAIObject> getUrgentTransportables() {
    List<TransportableAIObject> urgent = sort(transportSupply, ValuedAIObject.descendingValueComparator);
    int urge = urgent.size();
    urge = Math.max(2, (urge + 5) / 10);
    while (urgent.size() > urge) urgent.remove(urge);
    return urgent;
}