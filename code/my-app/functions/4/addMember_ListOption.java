private void addMember(AbstractOption<T> ao) {
    if (canAdd(ao))
        this.value.add(ao);
}