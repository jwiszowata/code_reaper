public void buildLogger() {
    this.logger = Logger.getLogger("net.sf.freecol" + ((this.name.isEmpty()) ? "" : "." + this.name));
    this.logger.setLevel(this.level);
}