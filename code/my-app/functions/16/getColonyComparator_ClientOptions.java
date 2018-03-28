public static Comparator<Colony> getColonyComparator(int type) {
    switch(type) {
        case COLONY_COMPARATOR_AGE:
            return colonyAgeComparator;
        case COLONY_COMPARATOR_POSITION:
            return colonyPositionComparator;
        case COLONY_COMPARATOR_SIZE:
            return colonySizeComparator;
        case COLONY_COMPARATOR_SOL:
            return colonySoLComparator;
        case COLONY_COMPARATOR_NAME:
            return colonyNameComparator;
        default:
            throw new IllegalStateException("Unknown comparator");
    }
}