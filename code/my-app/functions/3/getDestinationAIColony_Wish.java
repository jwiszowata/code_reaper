public AIColony getDestinationAIColony() {
    return (destination instanceof Colony) ? getAIMain().getAIColony((Colony) destination) : null;
}