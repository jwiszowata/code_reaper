public String invalidReason() {
    return (this.wish == null) ? "wish-null" : invalidReason(getAIUnit(), getTarget());
}