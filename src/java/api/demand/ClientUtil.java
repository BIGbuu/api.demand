package api.demand;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author BIG_bu
 */
public abstract class ClientUtil{
    private String  ip;
    private String  hostName;

    public ClientUtil() throws UnknownHostException {

    }
    public static String getIp() throws UnknownHostException{
        return InetAddress.getLocalHost().getHostAddress();
    }
    public static String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

}
