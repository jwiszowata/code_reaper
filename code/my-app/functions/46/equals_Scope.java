public boolean equals(Object o) {
    if (o == this)
        return true;
    if (o instanceof Scope) {
        Scope otherScope = (Scope) o;
        if (matchNegated != otherScope.matchNegated) {
            return false;
        }
        if (matchesNull != otherScope.matchesNull) {
            return false;
        }
        if (type == null) {
            if (otherScope.getType() != type) {
                return false;
            }
        } else if (!type.equals(otherScope.getType())) {
            return false;
        }
        if (abilityId == null) {
            if (!Utils.equals(otherScope.getAbilityId(), abilityId)) {
                return false;
            }
        } else if (!abilityId.equals(otherScope.getAbilityId())) {
            return false;
        }
        if (abilityValue != otherScope.getAbilityValue()) {
            return false;
        }
        if (methodName == null) {
            if (!Utils.equals(otherScope.getMethodName(), methodName)) {
                return false;
            }
        } else if (!methodName.equals(otherScope.getMethodName())) {
            return false;
        }
        if (methodValue == null) {
            if (!Utils.equals(otherScope.getMethodValue(), methodValue)) {
                return false;
            }
        } else if (!methodValue.equals(otherScope.getMethodValue())) {
            return false;
        }
        return true;
    }
    return false;
}