public Ability removeAbility(Ability ability) {
    FeatureContainer fc = getFeatureContainer();
    return (fc == null) ? null : fc.removeAbility(ability);
}