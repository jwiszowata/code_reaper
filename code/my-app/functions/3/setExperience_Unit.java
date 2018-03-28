public void setExperience(int experience) {
    this.experience = Math.min(experience, getType().getMaximumExperience());
}