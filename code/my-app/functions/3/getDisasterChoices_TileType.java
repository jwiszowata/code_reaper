public Stream<RandomChoice<Disaster>> getDisasterChoices() {
    return (this.disasters == null) ? Stream.<RandomChoice<Disaster>>empty() : disasters.stream();
}