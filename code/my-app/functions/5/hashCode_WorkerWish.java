public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.unitType);
    return 37 * hash + ((this.expertNeeded) ? 1 : 0);
}