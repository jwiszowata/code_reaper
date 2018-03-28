private void addAllowedWorker(String id) {
    if (allowedWorkers == null) {
        allowedWorkers = new HashSet<>();
    }
    allowedWorkers.add(id);
}