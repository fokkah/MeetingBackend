package fokka.se.meetingbackend;


import fokka.se.meetingbackend.REPO.MeetingRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {

    private final MeetingRepo meetingRepo;

    public CommandRunner(MeetingRepo meetingRepo) {
        this.meetingRepo = meetingRepo;

    }

    @Override
    public void run(String... args) throws Exception {

    }
}

