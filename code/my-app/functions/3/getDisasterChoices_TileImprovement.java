public Stream<RandomChoice<Disaster>> getDisasterChoices() {
    return (this.type == null) ? Stream.<RandomChoice<Disaster>>empty() : this.type.getDisasterChoices();
}