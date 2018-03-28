public boolean canUnitBeEquippedWith(JLabel data) {
    return getUnit().hasAbility(Ability.CAN_BE_EQUIPPED) && data instanceof AbstractGoodsLabel;
}