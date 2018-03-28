public <T extends Message> ChangeSet add(See see, T message) {
    changes.add(new MessageChange<T>(see, message));
    return this;
}