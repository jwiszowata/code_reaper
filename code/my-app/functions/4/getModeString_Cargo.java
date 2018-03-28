public String getModeString() {
    CargoMode mode = getMode();
    return (mode == null) ? "null" : mode.toString().toLowerCase(Locale.US);
}