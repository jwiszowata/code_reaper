public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + (type == null ? 0 : type.hashCode());
    hash = 31 * hash + (abilityId == null ? 0 : abilityId.hashCode());
    hash = 31 * hash + (abilityValue ? 1 : 0);
    hash = 31 * hash + (methodName == null ? 0 : methodName.hashCode());
    hash = 31 * hash + (methodValue == null ? 0 : methodValue.hashCode());
    hash = 31 * hash + (matchesNull ? 1 : 0);
    return 31 * hash + (matchNegated ? 1 : 0);
}