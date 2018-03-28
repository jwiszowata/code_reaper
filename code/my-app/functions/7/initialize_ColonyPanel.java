public void initialize() {
    super.initialize();
    final Colony colony = getColony();
    if (colony != null) {
        setName(colony.getName() + " - " + Messages.message("port"));
    }
}