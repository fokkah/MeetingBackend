package fokka.se.meetingbackend.REPO;

import fokka.se.meetingbackend.MODEL.MeetingInfo;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingRepo extends JpaRepository<MeetingInfo, Long> {
    
    
    Optional<MeetingInfo> findByMeetingId(Long meetingId);
    Optional<MeetingInfo> findByMeetingRequestEmail(String meetingRequestEmail);

    Optional<MeetingInfo> findByMeetingDate(LocalDate meetingDate, Limit limit);
    List<MeetingInfo> findAll();
    
    
}
