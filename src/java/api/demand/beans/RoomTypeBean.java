package api.demand.beans;

import java.util.List;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import api.demand.HibernateUtil;
import api.demand.model.RoomType;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author BIG_bu
 */

@Named("roomsBean")
@RequestScoped
public class RoomTypeBean {
    private List<RoomType> rooms;

    public void setRoom(RoomType room) {
        this.room = room;
    }
    private RoomType room;

    public RoomTypeBean() {
    }
    public RoomType getRoom() {
        return this.room;
    }
    
    public List<RoomType> getRooms() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        this.rooms = s.createCriteria(RoomType.class)
                .add(Restrictions.eq("deleted","0"))
                .list();
        s.close();
        return this.rooms;
    }
    
}
