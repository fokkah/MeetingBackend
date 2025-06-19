package fokka.se.meetingbackend.MODEL;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Validated
public class MeetingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    @Column
    @NotNull
    private String meetingTitle;

    @Column
    private String meetingDescription;

    @Column
    @NotNull
    @Email
    private String meetingRequestEmail;

    @Column
    private LocalDate meetingDate;

    @Column
    private LocalDate meetingStartTime;

    @Column
    private LocalDate meetingEndTime;




}
