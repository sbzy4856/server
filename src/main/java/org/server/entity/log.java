package org.server.entity;

public class log {
    private int logId;
    private String logAccount;
    private String logName;
    private String logTime;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLogAccount() {
        return logAccount;
    }

    public void setLogAccount(String logAccount) {
        this.logAccount = logAccount;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}
