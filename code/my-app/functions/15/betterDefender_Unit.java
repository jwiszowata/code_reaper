public static boolean betterDefender(Unit defender, double defenderPower, Unit other, double otherPower) {
    if (defender == null) {
        return true;
    } else if (defender.isPerson() && other.isPerson() && !defender.isArmed() && other.isArmed()) {
        return true;
    } else if (defender.isPerson() && other.isPerson() && defender.isArmed() && !other.isArmed()) {
        return false;
    } else if (!defender.isDefensiveUnit() && other.isDefensiveUnit()) {
        return true;
    } else if (defender.isDefensiveUnit() && !other.isDefensiveUnit()) {
        return false;
    } else {
        return defenderPower < otherPower;
    }
}