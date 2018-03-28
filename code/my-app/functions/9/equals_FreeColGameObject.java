public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof FreeColGameObject) {
        FreeColGameObject fco = (FreeColGameObject) o;
        return this.getGame() == fco.getGame() && super.equals(o);
    }
    return false;
}