public Stream<RandomChoice<Disaster>> getDisasterChoices() {
    return (disasters == null) ? Stream.<RandomChoice<Disaster>>empty() : disasters.stream();
}