private Integer ourCount(Collection<? extends FreeColObject> objects) {
    return count(objects, o -> this.appliesTo(o));
}