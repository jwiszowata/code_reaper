public Random getAIRandom() {
    return (unit == null) ? null : getAIOwner().getAIRandom();
}