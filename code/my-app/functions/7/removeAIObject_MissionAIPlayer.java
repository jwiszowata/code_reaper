public void removeAIObject(AIObject ao) {
    if (ao instanceof AIUnit) {
        removeAIUnit((AIUnit) ao);
    } else {
        super.removeAIObject(ao);
    }
}