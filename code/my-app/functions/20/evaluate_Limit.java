private boolean evaluate(Integer lhs, Integer rhs) {
    if (lhs == null || rhs == null)
        return true;
    int cmp = lhs.compareTo(rhs);
    switch(operator) {
        case EQ:
            return cmp == 0;
        case LT:
            return cmp < 0;
        case GT:
            return cmp > 0;
        case LE:
            return cmp <= 0;
        case GE:
            return cmp >= 0;
        default:
            break;
    }
    return false;
}