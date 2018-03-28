public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.unit);
    return 37 * hash + Utils.hashCode(this.mission);
}