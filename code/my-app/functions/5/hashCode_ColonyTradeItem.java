public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.colonyId);
    return 37 * hash + Utils.hashCode(this.colonyName);
}