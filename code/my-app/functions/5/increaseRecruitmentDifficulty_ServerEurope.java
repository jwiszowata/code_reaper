public void increaseRecruitmentDifficulty() {
    final Specification spec = getSpecification();
    recruitPrice += spec.getInteger(GameOptions.RECRUIT_PRICE_INCREASE);
    recruitLowerCap += spec.getInteger(GameOptions.LOWER_CAP_INCREASE);
}