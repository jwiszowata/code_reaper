public boolean isInMission() {
    return hasAbility(Ability.ESTABLISH_MISSION) && getLocation() instanceof IndianSettlement;
}