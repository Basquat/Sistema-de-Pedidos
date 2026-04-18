package com.example.sistemadepedidos.Role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Table(name = "ClientRole")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class clienteRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int roleID;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
