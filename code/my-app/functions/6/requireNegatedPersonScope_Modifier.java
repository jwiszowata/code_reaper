public boolean requireNegatedPersonScope() {
    if (hasScope())
        return false;
    addScope(Scope.makeNegatedPersonScope());
    return true;
}