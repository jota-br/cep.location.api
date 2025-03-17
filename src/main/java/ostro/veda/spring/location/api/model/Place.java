package ostro.veda.spring.location.api.dto;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Address address;

    @ManyToMany(mappedBy = "visitedPlaces")
    private List<User> users = new ArrayList<>();
}