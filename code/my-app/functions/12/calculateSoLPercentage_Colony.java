private int calculateSoLPercentage(int uc, int liberty) {
    if (uc <= 0)
        return -1;
    float membership = (liberty * 100.0f) / (LIBERTY_PER_REBEL * uc);
    membership = applyModifiers(membership, getGame().getTurn(), getOwner().getModifiers(Modifier.SOL));
    if (membership < 0.0f) {
        membership = 0.0f;
    } else if (membership > 100.0f) {
        membership = 100.0f;
    }
    return (int) membership;
}