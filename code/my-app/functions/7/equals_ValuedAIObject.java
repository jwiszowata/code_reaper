public boolean equals(Object other) {
    if (other instanceof ValuedAIObject) {
        ValuedAIObject ov = (ValuedAIObject) other;
        return super.equals(ov) && this.value == ov.value;
    }
    return false;
}