public String invalidReason() {
    if (tileImprovementPlan != null) {
        if (tileImprovementPlan.isDisposed()) {
            return "target-plan-disposed";
        }
        if (tileImprovementPlan.isComplete())
            return null;
    }
    return invalidReason(getAIUnit(), getTarget());
}