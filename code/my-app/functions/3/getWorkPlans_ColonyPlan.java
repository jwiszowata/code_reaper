public List<WorkLocationPlan> getWorkPlans() {
    return transform(workPlans, wp -> !wp.isFoodPlan() && !wp.getWorkLocation().canAutoProduce());
}