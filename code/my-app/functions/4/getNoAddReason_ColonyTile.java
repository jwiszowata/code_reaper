public NoAddReason getNoAddReason(Locatable locatable) {
    NoAddReason reason = super.getNoAddReason(locatable);
    return (reason != NoAddReason.NONE) ? reason : getNoWorkReason();
}