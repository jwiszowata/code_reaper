public static Cargo newCargo(TransportableAIObject t, Unit carrier) throws FreeColException {
    return newCargo(t, carrier, t.getTransportDestination(), true);
}