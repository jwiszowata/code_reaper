public Stream<RandomChoice<Disaster>> getDisasterChoices() {
    return concat(type.getDisasterChoices(), flatten(getCompleteTileImprovements(), ti -> ti.getDisasterChoices()));
}