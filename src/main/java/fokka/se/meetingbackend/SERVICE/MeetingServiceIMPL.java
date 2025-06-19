package fokka.se.meetingbackend.SERVICE;

import fokka.se.meetingbackend.DTO.MeetingDTO;
import fokka.se.meetingbackend.MODEL.MeetingInfo;
import fokka.se.meetingbackend.REPO.MeetingRepo;
import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        MeetingInfo meetingInfo = meetingRepo.findByMeetingRequestEmail(meetingRequestEmail).orElseThrow(() ->(new RuntimeException("Email not in system")));
        return MeetingDTO.builder()
                .meetingRequestEmail(meetingInfo.getMeetingRequestEmail())
                .build();
    }

    @Override
    public MeetingDTO findByMeetingDate(LocalDate meetingDate, Limit limit) {

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
                                    LocalDate meetingStartTime,
                                    LocalDate meetingEndTime,
                                    String meetingRequestEmail) {
        return null;
    }
}
