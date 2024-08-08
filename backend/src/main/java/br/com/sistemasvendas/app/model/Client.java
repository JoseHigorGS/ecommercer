package br.com.sistemasvendas.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer id;
    @Column(name = "name_client", length = 100)
    private String name;
    @Column(name = "email_client", length = 100)
    private String email;
    @Column(name = "cep_client",length = 8)
    private String cep;
    @Column(name = "address_client",length = 100)
    private String address;
    @Column(name = "number_client", length = 50)
    private String number;
    @Column(name = "city_client", length = 100)
    private String city;
    @Column(name = "state_client",length = 100)
    private String state;
    @Column(name = "phone_client",length = 20)
    private String phone;
}
