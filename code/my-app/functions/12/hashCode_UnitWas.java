public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(unit);
    hash = 37 * hash + Utils.hashCode(type);
    hash = 37 * hash + Utils.hashCode(role);
    hash = 37 * hash + roleCount;
    hash = 37 * hash + Utils.hashCode(loc);
    hash = 37 * hash + Utils.hashCode(work);
    hash = 37 * hash + workAmount;
    hash = 37 * hash + movesLeft;
    return 37 * hash + Utils.hashCode(colony);
}