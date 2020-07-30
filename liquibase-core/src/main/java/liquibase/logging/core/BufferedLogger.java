package liquibase.logging.core;

import java.util.logging.Level;

public class BufferedLogger extends AbstractLogger {

    private BufferedLogService bufferedLogService;
    private Class clazz;

    public BufferedLogger(Class clazz, BufferedLogService bufferedLogService) {
        this.clazz = clazz;
        this.bufferedLogService = bufferedLogService;
    }

    @Override
    public void log(Level level, String message, Throwable e) {
        this.bufferedLogService.addLog(new BufferedLogService.BufferedLogMessage(level, clazz, message, e));
    }

    @Override
    public void close() throws Exception {

    }

}
