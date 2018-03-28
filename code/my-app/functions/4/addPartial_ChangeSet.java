public ChangeSet addPartial(See see, FreeColGameObject fcgo, String... fields) {
    changes.add(new PartialObjectChange(see, fcgo, new ArrayList<>(Arrays.asList(fields))));
    return this;
}