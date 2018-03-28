public String invalidReason() {
    final AIUnit aiUnit = getAIUnit();
    String reason = invalidReason(aiUnit, getTarget());
    Cargo cargo;
    return (reason != null) ? reason : ((cargo = tFirst()) == null) ? null : invalidCargoReason(cargo);
}