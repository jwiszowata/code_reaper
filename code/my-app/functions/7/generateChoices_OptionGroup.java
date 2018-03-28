public void generateChoices() {
    for (Option o : options) {
        if (o instanceof AbstractOption) {
            ((AbstractOption) o).generateChoices();
        }
    }
}