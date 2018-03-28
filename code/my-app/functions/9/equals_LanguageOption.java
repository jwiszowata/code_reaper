public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof Language) {
        Language l = (Language) o;
        return Utils.equals(this.key, l.key) && super.equals(o);
    }
    return false;
}