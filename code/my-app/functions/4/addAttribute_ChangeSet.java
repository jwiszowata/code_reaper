public ChangeSet addAttribute(See see, String key, String value) {
    changes.add(new AttributeChange(see, key, value));
    return this;
}