public boolean equals(Object other) {
    if (other instanceof TransportableAIObject) {
        TransportableAIObject ot = (TransportableAIObject) other;
        return super.equals(ot) && Utils.equals(this.transport, ot.transport);
    }
    return false;
}