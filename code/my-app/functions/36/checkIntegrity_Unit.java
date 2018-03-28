public int checkIntegrity(boolean fix) {
    int result = super.checkIntegrity(fix);
    if (this.role == null) {
        if (fix) {
            this.role = getSpecification().getDefaultRole();
            logger.warning("Fixed missing role for: " + getId());
            result = 0;
        } else {
            logger.warning("Missing role for: " + getId());
            result = -1;
        }
    }
    if (this.destination != null) {
        if (!((FreeColGameObject) this.destination).isInitialized()) {
            if (fix) {
                this.destination = null;
                logger.warning("Cleared uninitialized destination for: " + getId());
                result = Math.min(result, 0);
            } else {
                logger.warning("Uninitialized destination for: " + getId());
                result = -1;
            }
        }
    }
    if (this.state == UnitState.IMPROVING && this.workImprovement == null) {
        if (fix) {
            this.state = UnitState.ACTIVE;
            logger.warning("Made improving unit active: " + getId());
            result = Math.min(result, 0);
        } else {
            logger.warning("Improving unit with no improvement: " + getId());
            result = -1;
        }
    }
    return result;
}