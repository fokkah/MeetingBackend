package fokka.se.meetingbackend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record MeetingDTO(

        Long meetingId,
        @Size(min = 5, max = 20)
        @NotNull
        String meetingTitle,

        @Size(min = 5, max = 50)
        String meetingDescription,

        @NotNull
        @Email
        String meetingRequestEmail,

        @Email
        LocalDate meetingDate,

        @NotNull
        LocalTime meetingStartTime,

        @NotNull
        LocalTime meetingEndTime)

        {


}
