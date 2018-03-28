public boolean equals(Object o) {
    if (o instanceof FreeColObject) {
        FreeColObject fco = (FreeColObject) o;
        return Utils.equals(this.id, fco.id);
    }
    return false;
}