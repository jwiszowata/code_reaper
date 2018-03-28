private static String invalidCargoReason(Cargo cargo) {
    final TransportableAIObject t = cargo.getTransportable();
    String reason;
    return (t == null) ? "null-transportable" : ((reason = t.invalidReason()) != null) ? "cargo-" + reason : null;
}