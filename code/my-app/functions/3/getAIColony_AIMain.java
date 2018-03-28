public AIColony getAIColony(Colony colony) {
    return getAIObject(colony.getId(), AIColony.class);
}