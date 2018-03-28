public String getType() {
    return (this.document != null && getElement() != null) ? DOMUtils.getType(getElement()) : INVALID_MESSAGE;
}