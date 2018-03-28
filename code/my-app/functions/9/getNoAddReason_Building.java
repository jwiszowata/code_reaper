public NoAddReason getNoAddReason(Locatable locatable) {
    NoAddReason reason = super.getNoAddReason(locatable);
    if (reason == NoAddReason.NONE) {
        reason = getType().getNoAddReason(((Unit) locatable).getType());
        if (reason == NoAddReason.NONE)
            reason = getNoWorkReason();
    }
    return reason;
}