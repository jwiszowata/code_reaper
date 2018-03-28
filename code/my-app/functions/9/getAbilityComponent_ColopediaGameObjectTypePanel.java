public JLabel getAbilityComponent(Ability ability) {
    if (ability.getValue()) {
        JLabel label = new JLabel(ModifierFormat.getFeatureAsString(ability));
        label.setToolTipText(Messages.getShortDescription(ability));
        return label;
    } else {
        return null;
    }
}