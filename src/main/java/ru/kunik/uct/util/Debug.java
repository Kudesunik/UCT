package ru.kunik.uct.util;

import java.util.HashMap;
import java.util.Map;
import ru.kunik.uct.MainHandler;

public class Debug {
    
    private static LogManager log = new LogManager(null, "Debug");
    private static Map<String, Long> profilerMap = new HashMap<String, Long>();
    
    public static void startProfiler(String method) {
        profilerMap.put(method, System.currentTimeMillis());
    }
    
    public static void stopProfiler(String method) {
        profilerMap.put(method, (System.currentTimeMillis() - profilerMap.get(method)));
        if (MainHandler.isDebugging) {
            addDebugTime(method, profilerMap.get(method));
        }
    }
    
    public static void addDebugTime(String method, long time) {
        log.writeLog("Method \'" + method + "\' done in " + time + " milliseconds", false);
    }
}
