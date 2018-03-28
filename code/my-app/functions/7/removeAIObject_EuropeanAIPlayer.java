public void removeAIObject(AIObject ao) {
    if (ao instanceof AIColony) {
        removeAIColony((AIColony) ao);
    } else {
        super.removeAIObject(ao);
    }
}