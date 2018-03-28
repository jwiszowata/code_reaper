protected int compareNames(Location loc1, Location loc2) {
    if (!(loc1 instanceof Settlement))
        return -1;
    if (!(loc2 instanceof Settlement))
        return 1;
    Settlement s1 = (Settlement) loc1;
    String name1 = Messages.message(s1.getLocationLabelFor(owner));
    Settlement s2 = (Settlement) loc2;
    String name2 = Messages.message(s2.getLocationLabelFor(owner));
    return name1.compareTo(name2);
}