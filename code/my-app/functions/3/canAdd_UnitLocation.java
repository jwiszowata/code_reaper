public boolean canAdd(Locatable locatable) {
    return getNoAddReason(locatable) == NoAddReason.NONE;
}