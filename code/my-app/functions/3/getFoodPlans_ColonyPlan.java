public List<WorkLocationPlan> getFoodPlans() {
    return transform(workPlans, wp -> wp.isFoodPlan() && !wp.getWorkLocation().canAutoProduce());
}