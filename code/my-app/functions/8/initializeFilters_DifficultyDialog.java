private void initializeFilters() {
    synchronized (filters) {
        if (filters[0] == null) {
            String desc = Messages.message("filter.xml");
            filters[0] = new FileNameExtensionFilter(desc, "xml");
        }
    }
}