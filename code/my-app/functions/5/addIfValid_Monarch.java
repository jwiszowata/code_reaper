private void addIfValid(List<RandomChoice<MonarchAction>> choices, MonarchAction action, int weight) {
    if (actionIsValid(action)) {
        choices.add(new RandomChoice<>(action, weight));
    }
}