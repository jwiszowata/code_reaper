public WorkLocation getWorkLocationWithAbility(String ability) {
    return find(getCurrentWorkLocations(), wl -> wl.hasAbility(ability));
}