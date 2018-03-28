public LogoutReason getReason() {
    return Enum.valueOf(LogoutReason.class, getStringAttribute(REASON_TAG));
}