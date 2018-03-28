public String getNextId() {
    String id = Integer.toString(nextId);
    nextId++;
    return id;
}