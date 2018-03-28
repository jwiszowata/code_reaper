public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof ModOption) {
        ModOption mod = (ModOption) o;
        return this.value == mod.value && super.equals(o);
    }
    return false;
}