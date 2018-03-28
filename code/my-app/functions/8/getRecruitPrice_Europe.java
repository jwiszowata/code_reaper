public int getRecruitPrice() {
    if (!owner.isColonial())
        return -1;
    int required = owner.getImmigrationRequired();
    int immigration = owner.getImmigration();
    int difference = Math.max(required - immigration, 0);
    return Math.max((recruitPrice * difference) / required, recruitLowerCap);
}