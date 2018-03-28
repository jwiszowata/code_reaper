public boolean canAdd(AbstractOption<T> ao) {
    return (allowDuplicates) ? true : none(value, matchKey(ao));
}