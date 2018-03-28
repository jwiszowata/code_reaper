public boolean canBombardEnemyShip() {
    return (isLandLocked()) ? false : hasAbility(Ability.BOMBARD_SHIPS);
}