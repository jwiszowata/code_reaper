public final RandomRange getPlunderRange(Unit unit) {
    if (this.plunder == null)
        return null;
    PlunderType pt = find(plunder, p -> p.appliesTo(unit));
    return (pt == null) ? null : pt.getPlunder();
}