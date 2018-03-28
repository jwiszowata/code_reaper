public boolean accepts(Unit unit) {
    if (!unit.isNaval())
        return false;
    switch(unit.getState()) {
        case ACTIVE:
        case FORTIFIED:
        case FORTIFYING:
        case SENTRY:
        case SKIPPED:
            return true;
    }
    return false;
}