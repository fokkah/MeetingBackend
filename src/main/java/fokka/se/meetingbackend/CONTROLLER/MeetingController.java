package fokka.se.meetingbackend.CONTROLLER;

import fokka.se.meetingbackend.DTO.MeetingDTO;
import fokka.se.meetingbackend.SERVICE.MeetingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping("/api/calendar")
@Validated
public class MeetingController {


    private MeetingService meetingService;
    private StringHttpMessageConverter stringHttpMessageConverter;
    private MeetingDTO meetingDTO;

    @Autowired
    public MeetingController(MeetingService meetingService, StringHttpMessageConverter stringHttpMessageConverter) {
        this.meetingService = meetingService;
        this.stringHttpMessageConverter = stringHttpMessageConverter;
    }

    public MeetingController(MeetingDTO meetingDTO) {
        this.meetingDTO = meetingDTO;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<MeetingDTO> getMeetings() {
        return meetingService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MeetingDTO createMeeting(@RequestParam @Valid String meetingRequestEmail,
                                    @RequestParam String meetingTitle,
                                    @RequestParam(required = false) String meetingDescription,
                                    @RequestParam LocalDate meetingDate,
                                    @RequestParam(required = false) LocalTime meetingStartTime,
                                    @RequestParam(required = false) LocalTime meetingEndTime){

        return meetingService.createMeeting(meetingTitle, meetingDescription, meetingDate, meetingStartTime, meetingEndTime, meetingRequestEmail);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MeetingDTO updateMeetingById(
            @PathVariable("id") Long meetingId,
            @RequestParam String meetingTitle,
            @RequestParam(required = false) String meetingDescription,
            @RequestParam LocalDate meetingDate,
            @RequestParam(required = false) LocalTime meetingStartTime,
            @RequestParam(required = false) LocalTime meetingEndTime,
            @RequestParam @Valid String meetingRequestEmail){
        return meetingService.updateMeetingById(meetingId, meetingTitle, meetingDescription, meetingDate, meetingStartTime, meetingEndTime, meetingRequestEmail);
    }


}
