public static NoValueType fromValue(int i) {
    int n = -i - 1;
    return (n >= 0 && n < MAX) ? NoValueType.values()[n] : BOGUS;
}