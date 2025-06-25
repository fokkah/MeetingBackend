package fokka.se.meetingbackend.SERVICE;

import fokka.se.meetingbackend.DTO.MeetingDTO;
import fokka.se.meetingbackend.MODEL.MeetingInfo;
import fokka.se.meetingbackend.REPO.MeetingRepo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MeetingService {

    MeetingRepo meetingRepo();
    MeetingInfo meetingInfo();

    List<MeetingDTO> findAll();

    MeetingDTO findByMeetingRequestEmail(String meetingRequestEmail);

    MeetingDTO findByMeetingId(Long meetingId);




    MeetingDTO createMeeting(String meetingTitle,
                             String meetingDescription,
                             LocalDate meetingDate,
                             LocalTime meetingStartTime,
                             LocalTime meetingEndTime,
                             String meetingRequestEmail);

    MeetingDTO updateMeetingById(Long meetingId,
                            String meetingTitle,
                             String meetingDescription,
                             LocalDate meetingDate,
                             LocalTime meetingStartTime,
                             LocalTime meetingEndTime,
                             String meetingRequestEmail);

    MeetingDTO acceptMeeting(Long meetingId);

    MeetingDTO deleteMeeting(Long meetingId);

}
