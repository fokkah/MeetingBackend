package fokka.se.meetingbackend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record MeetingRequestDTO(


        @NotNull @Email String meetingRequestEmail,
        @NotNull String meetingTitle,
        String meetingDescription,
        @NotNull LocalDate meetingDate,
        @NotNull LocalTime meetingStartTime,
        @NotNull LocalTime meetingEndTime
) {}
