package relife.huranit.domain.reservation.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import relife.huranit.domain.center.domain.Center;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="reserve_id" , updatable = false)
    private Long reserveId;

    @ManyToOne
    @JoinColumn(name = "center_Id" , nullable = false)
    private Center center;

    @Column(nullable = false , length = 50)
    private String companyName;

    @Column(nullable = false , length = 50)
    private String departmentName;

    @Column(nullable = false , length = 50)
    private String name;

    @Column(nullable = false , length = 50)
    private String email;

    @Column
    private String companyCall;

    @Column
    private String userCall;

    @Column
    private String seat;

    @Column
    LocalDate reserveDay;

    @Column
    LocalTime reserveTime;
}
