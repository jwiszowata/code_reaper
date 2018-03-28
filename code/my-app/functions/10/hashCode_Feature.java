public int hashCode() {
    int hash = super.hashCode();
    hash += 31 * hash + Utils.hashCode(source);
    hash += 31 * hash + ((firstTurn == null) ? 0 : firstTurn.getNumber());
    hash += 31 * hash + ((lastTurn == null) ? 0 : lastTurn.getNumber());
    hash += 31 * hash + duration;
    hash += 31 * ((temporary) ? 1 : 0);
    hash += sum(getScopeList(), s -> Utils.hashCode(s));
    return hash;
}