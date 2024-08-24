package relife.huranit.domain.center.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import relife.huranit.domain.centertag.domain.CenterTag;
import relife.huranit.domain.reservation.domain.Reservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="center_id" , updatable = false)
    private Long centerId;

    @Column(nullable = false ,length =50)
    private String name;

    @Column
    private String imageUrl;

    @Column(nullable = false , length = 50)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String addressDetail1; //구

    @Column(nullable = false, length = 50)
    private String addressDetail2; //도로명 주소

    @Column(nullable = false, length = 50)
    private String addressDetail3; // 건물

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column
    private LocalTime lunchStartTime;

    @Column
    private LocalTime lunchEndTime;

    @OneToMany(mappedBy = "center" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<CenterTag> centerTagList = new ArrayList<>();

    @OneToMany(mappedBy = "center" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<Reservation> reservationList = new ArrayList<>();

    @Builder
    public Center(String name , String phoneNumber , String addressDetail1 , String addressDetail2 , String addressDetail3 ,LocalTime startTime , LocalTime endTime , LocalTime lunchStartTime , LocalTime lunchEndTime ){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressDetail1 = addressDetail1;
        this.addressDetail2 = addressDetail2;
        this.addressDetail3 = addressDetail3;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
    }
}
