public synchronized void removeDeadServers() {
    logger.info("Removing dead servers.");
    long time = System.currentTimeMillis() - REMOVE_OLDER_THAN;
    for (int i = 0; i < items.size(); i++) {
        if (items.get(i).getLastUpdated() < time) {
            logger.info("Removing: " + items.get(i));
            items.remove(i);
        }
    }
}