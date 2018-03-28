public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof ChoiceItem) {
        ChoiceItem ci = (ChoiceItem) o;
        return Utils.equals(this.text, ci.toString()) && Utils.equals(this.getObject(), ci.getObject());
    }
    return false;
}