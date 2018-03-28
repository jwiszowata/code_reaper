public int compareTo(Arrangement other) {
    int cmp = this.role.compareTo(other.role);
    if (cmp == 0)
        cmp = this.roleCount - other.roleCount;
    return cmp;
}