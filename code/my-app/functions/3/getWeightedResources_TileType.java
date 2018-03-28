public List<RandomChoice<ResourceType>> getWeightedResources() {
    return (resourceTypes == null) ? Collections.<RandomChoice<ResourceType>>emptyList() : resourceTypes;
}