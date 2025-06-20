package fokka.se.meetingbackend.SERVICE;

import fokka.se.meetingbackend.DTO.MeetingDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MeetingService {

    List<MeetingDTO> findAll();

    MeetingDTO findByMeetingRequestEmail(String meetingRequestEmail);

    MeetingDTO findByMeetingDate(LocalDate meetingDate);

    MeetingDTO findByMeetingTitle(String meetingTitle);


    MeetingDTO createMeeting(String meetingTitle,
                             String meetingDescription,
                             LocalDate meetingDate,
                             LocalTime meetingStartTime,
                             LocalTime meetingEndTime,
                             String meetingRequestEmail);
}
