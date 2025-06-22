package fokka.se.meetingbackend.SERVICE;

import fokka.se.meetingbackend.DTO.MeetingDTO;
import fokka.se.meetingbackend.MODEL.MeetingInfo;
import fokka.se.meetingbackend.REPO.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingServiceIMPL implements MeetingService{

    private final MeetingRepo meetingRepo;


    @Autowired
    public MeetingServiceIMPL(MeetingRepo meetingRepo) {
        this.meetingRepo = meetingRepo;
    }


    @Override
    public List<MeetingDTO> findAll() {
        List<MeetingInfo> meetingInfoList = meetingRepo.findAll();
        return meetingInfoList.stream().map(A -> MeetingDTO.builder()
                .meetingId(A.getMeetingId())
                .meetingRequestEmail(A.getMeetingRequestEmail())
                .meetingDate(A.getMeetingDate())
                .meetingDescription(A.getMeetingDescription())
                .meetingTitle(A.getMeetingTitle())
                .meetingStartTime(A.getMeetingStartTime())
                .meetingEndTime(A.getMeetingEndTime())
        .build()).collect(Collectors.toList());
    }

    @Override
    public MeetingDTO findByMeetingRequestEmail(String meetingRequestEmail) {
        List<MeetingInfo> meetings = meetingRepo.findByMeetingRequestEmail(meetingRequestEmail);
        if (meetings.isEmpty()) {
            throw new RuntimeException("Email not in system. " + meetingRequestEmail);
        }
        return meetingRepo.findAll().stream().filter(M -> M.getMeetingRequestEmail().equals(meetingRequestEmail)).map(A -> MeetingDTO.builder()
                .meetingId(A.getMeetingId())
                .meetingRequestEmail(A.getMeetingRequestEmail())
                .meetingDate(A.getMeetingDate())
                .meetingTitle(A.getMeetingTitle())
                .build()).collect(Collectors.toList()).get(0);
    }

    @Override
    public MeetingDTO findByMeetingDate(LocalDate meetingDate) {

        return null;
    }

    @Override
    public MeetingDTO findByMeetingTitle(String meetingTitle) {
        return null;
    }

    @Override
    public MeetingDTO createMeeting(String meetingTitle,
                                    String meetingDescription,
                                    LocalDate meetingDate,
                                    LocalTime meetingStartTime,
                                    LocalTime meetingEndTime,
                                    String meetingRequestEmail) {
            try {
            if (meetingRepo.findByMeetingDate(meetingDate, null).isEmpty()){

                meetingRepo.save(MeetingInfo.builder()
                        .meetingTitle(meetingTitle)
                        .meetingDescription(meetingDescription)
                        .meetingDate(meetingDate)
                        .meetingStartTime(meetingStartTime)
                        .meetingEndTime(meetingEndTime)
                        .meetingRequestEmail(meetingRequestEmail)
                        .build());
            return MeetingDTO.builder()
                .meetingTitle(meetingTitle)
                .meetingDescription(meetingDescription)
                .meetingDate(meetingDate)
                .meetingStartTime(meetingStartTime)
                .meetingEndTime(meetingEndTime)
                .meetingRequestEmail(meetingRequestEmail)
                .build();
            } else if (meetingRepo.findByMeetingDate(meetingDate, null).isPresent()) {
                return MeetingDTO.builder()
                        .meetingDate(meetingRepo.findByMeetingDate(meetingDate, null).get().getMeetingDate())
                        .meetingRequestEmail(String.valueOf(meetingRepo.findByMeetingRequestEmail(meetingRequestEmail)))
                        .build();

                }
                throw new RuntimeException("Meeting creaton failed");
            }catch (RuntimeException e) {
                throw new RuntimeException("Meeting already exists");
        }
    }
}
