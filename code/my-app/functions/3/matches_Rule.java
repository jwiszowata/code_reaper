public boolean matches(double number) {
    return any(conditions, andConditions -> all(andConditions, r -> r.matches(number)));
}