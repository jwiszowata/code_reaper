private void addDisaster(Disaster disaster, int probability) {
    if (disasters == null)
        disasters = new ArrayList<>();
    disasters.add(new RandomChoice<>(disaster, probability));
}