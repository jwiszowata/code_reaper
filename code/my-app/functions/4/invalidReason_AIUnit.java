public String invalidReason() {
    String reason = Mission.invalidTransportableReason(this);
    return (reason != null) ? reason : (hasMission()) ? getMission().invalidReason() : null;
}