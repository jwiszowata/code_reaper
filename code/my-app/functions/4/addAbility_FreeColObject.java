public boolean addAbility(Ability ability) {
    FeatureContainer fc = getFeatureContainer();
    return (fc == null) ? false : fc.addAbility(ability);
}