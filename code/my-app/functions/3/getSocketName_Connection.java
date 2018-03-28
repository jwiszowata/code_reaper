public String getSocketName() {
    return (isAlive()) ? getHostAddress() + ":" + getPort() : "";
}