package relife.huranit.domain.reservation.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    private LocalDate reserveDay;

    @Column
    private LocalTime reserveTime;

    @Builder
    public Reservation(Center center , String companyName , String departmentName, String name , String email , String companyCall , String userCall , String seat , LocalDate reserveDay , LocalTime reserveTime){
        this.center = center;
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.name = name;
        this.email = email;
        this.companyCall = companyCall;
        this.userCall = userCall;
        this.seat = seat;
        this.reserveDay = reserveDay;
        this.reserveTime = reserveTime;
    }
}
