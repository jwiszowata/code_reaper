public NoAddReason getNoAddReason(Locatable locatable) {
    return (locatable instanceof Unit && ((Unit) locatable).isNaval()) ? NoAddReason.NONE : NoAddReason.WRONG_TYPE;
}