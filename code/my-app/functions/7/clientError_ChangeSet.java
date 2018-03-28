public static ChangeSet clientError(See see, String message) {
    ChangeSet cs = new ChangeSet();
    if (see == null)
        see = See.all();
    cs.add(see, new ErrorMessage(message));
    return cs;
}