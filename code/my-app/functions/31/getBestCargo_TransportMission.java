private Cargo getBestCargo(Unit carrier) {
    final EuropeanAIPlayer euaip = getEuropeanAIPlayer();
    Cargo bestDirect = null, bestFallback = null;
    float bestDirectValue = 0.0f, bestFallbackValue = 0.0f;
    for (TransportableAIObject t : euaip.getUrgentTransportables()) {
        if (t.isDisposed() || !t.carriableBy(carrier))
            continue;
        Location loc = t.getTransportSource();
        Cargo cargo;
        try {
            cargo = Cargo.newCargo(t, carrier);
        } catch (FreeColException fce) {
            cargo = null;
        }
        if (cargo == null)
            continue;
        float value = t.getTransportPriority() / (cargo.getTurns() + 1.0f);
        if (cargo.isFallback()) {
            if (bestFallbackValue < value) {
                bestFallbackValue = value;
                bestFallback = cargo;
            }
        } else {
            if (bestDirectValue < value) {
                bestDirectValue = value;
                bestDirect = cargo;
            }
        }
    }
    return (bestDirect != null) ? bestDirect : (bestFallback != null) ? bestFallback : null;
}