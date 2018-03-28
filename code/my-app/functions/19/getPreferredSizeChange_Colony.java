public int getPreferredSizeChange() {
    int i, limit, pop = getUnitCount();
    if (productionBonus < 0) {
        limit = pop;
        for (i = 1; i < limit; i++) {
            if (governmentChange(pop - i) == 1)
                break;
        }
        return -i;
    } else {
        final Specification spec = getSpecification();
        limit = CHANGE_UPPER_BOUND;
        for (i = 1; i <= limit; i++) {
            if (governmentChange(pop + i) == -1)
                break;
        }
        return i - 1;
    }
}