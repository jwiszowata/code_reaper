private void addResourceType(ResourceType type, int prob) {
    if (resourceTypes == null)
        resourceTypes = new ArrayList<>();
    resourceTypes.add(new RandomChoice<>(type, prob));
}