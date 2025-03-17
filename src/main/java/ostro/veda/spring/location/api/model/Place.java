package ostro.veda.spring.location.api.dto;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "addressId", nullable = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private User user;
}