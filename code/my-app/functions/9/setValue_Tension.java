public final void setValue(int newValue) {
    if (newValue < TENSION_MIN) {
        value = TENSION_MIN;
    } else if (newValue > TENSION_MAX) {
        value = TENSION_MAX;
    } else {
        value = newValue;
    }
}