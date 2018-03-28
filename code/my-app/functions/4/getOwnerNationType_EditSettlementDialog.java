private IndianNationType getOwnerNationType() {
    Nation n = getOwnerNation();
    return (n == null) ? null : (IndianNationType) n.getType();
}