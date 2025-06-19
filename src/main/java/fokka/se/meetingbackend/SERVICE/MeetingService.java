package fokka.se.meetingbackend.SERVICE;

import fokka.se.meetingbackend.DTO.MeetingDTO;
import org.hibernate.query.spi.Limit;

import java.time.LocalDate;
import java.util.List;

public interface MeetingService {

    List<MeetingDTO> findAll();

    MeetingDTO findByMeetingRequestEmail(String meetingRequestEmail);

    MeetingDTO findByMeetingDate(LocalDate meetingDate, Limit limit);

    MeetingDTO findByMeetingTitle(String meetingTitle);


    MeetingDTO createMeeting(String meetingTitle,
                             String meetingDescription,
                             LocalDate meetingDate,
                             LocalDate meetingStartTime,
                             LocalDate meetingEndTime,
                             String meetingRequestEmail);
}
