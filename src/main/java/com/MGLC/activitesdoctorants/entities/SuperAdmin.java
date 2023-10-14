package com.MGLC.activitesdoctorants.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(("SUPER-ADMIN"))
public class SuperAdmin extends Personne{
}
