public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof Ability) {
        return this.value == ((Ability) o).value && super.equals(o);
    }
    return false;
}