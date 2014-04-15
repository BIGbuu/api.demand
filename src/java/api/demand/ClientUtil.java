package api.demand;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) ipAddress = request.getRemoteAddr();  // IP
        
        return ipAddress;
//        return InetAddress.getLocalHost().getHostAddress();
    }
    public static String getHostName() throws UnknownHostException{
        InetAddress addr = InetAddress.getByName(ClientUtil.getIp());  // DOMAIN NAME from IP
        String host = addr.getHostName();        
        
        return host;
//        return InetAddress.getLocalHost().getHostName();
    }

}
