private String clearCargoes() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("cargoes cleared: ");
    for (Cargo cargo : tClear()) {
        dropTransportable(cargo.getTransportable());
        sb.append(' ').append(cargo);
    }
    tRetarget();
    return sb.toString();
}