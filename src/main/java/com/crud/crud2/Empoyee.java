package com.crud.crud2;

import jakarta.persistence.*;


@Entity
@Table
public class Empoyee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @Column
        private String name;
        public Empoyee(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
        public Empoyee() {
            super();
            // TODO Auto-generated constructor stub
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Empoyee [id=" + id + ", name=" + name + "]";
        }


}
