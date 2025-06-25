package fokka.se.meetingbackend.CONTROLLER;

import fokka.se.meetingbackend.DTO.MeetingDTO;
import fokka.se.meetingbackend.DTO.MeetingRequestDTO;
import fokka.se.meetingbackend.SERVICE.MeetingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/calendar")
@Validated
public class MeetingController {


    private MeetingService meetingService;
    private StringHttpMessageConverter stringHttpMessageConverter;
    private MeetingDTO meetingDTO;
    private MeetingRequestDTO meetingRequestDTO;

    @Autowired
    public MeetingController(MeetingService meetingService, StringHttpMessageConverter stringHttpMessageConverter) {
        this.meetingService = meetingService;
        this.stringHttpMessageConverter = stringHttpMessageConverter;
    }

    public MeetingController(MeetingDTO meetingDTO) {
        this.meetingDTO = meetingDTO;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MeetingDTO> getMeetings(@RequestBody(required = false) MeetingRequestDTO meetingRequestDTO) {
        return meetingService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MeetingDTO createMeeting(@RequestBody @Valid MeetingRequestDTO meetingRequestDTO) {

        return meetingService.createMeeting(
                meetingRequestDTO.meetingTitle(),
                meetingRequestDTO.meetingDescription(),
                meetingRequestDTO.meetingDate(),
                meetingRequestDTO.meetingStartTime(),
                meetingRequestDTO.meetingEndTime(),
                meetingRequestDTO.meetingRequestEmail()
        );

    }

    @PutMapping("/{id}/accept")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> acceptMeeting (@PathVariable Long id) {
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{meetingId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteMeeting (@PathVariable Long meetingId) {
        meetingService.deleteMeeting(meetingId);
        return ResponseEntity.noContent().build();
    }


}
