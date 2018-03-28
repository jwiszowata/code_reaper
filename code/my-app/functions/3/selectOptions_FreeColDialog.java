private Object[] selectOptions() {
    return transform(this.options, ChoiceItem::isEnabled).toArray();
}