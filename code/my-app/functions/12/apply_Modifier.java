private float apply(float base, float value, ModifierType type) {
    switch(type) {
        case ADDITIVE:
            return base + value;
        case MULTIPLICATIVE:
            return base * value;
        case PERCENTAGE:
            return base + (base * value) / 100;
        default:
            return base;
    }
}