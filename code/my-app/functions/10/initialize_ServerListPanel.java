public void initialize(List<ServerInfo> servers) {
    removeInPlace(servers, si -> !si.getVersion().equals(FreeCol.getVersion()));
    tableModel.setItems(servers);
    setEnabled(true);
    if (servers.isEmpty()) {
        connect.setEnabled(false);
    } else {
        table.setRowSelectionInterval(0, 0);
    }
}