package com.example.android_game_app_ailatrieuphu.object;

public class User {
        private int id;
        private String email;
        private  String password;
        private String totalpoint;

        public User(String email, String password, String totalpoint) {
            this.email = email;
            this.password = password;
            this.totalpoint = totalpoint;
        }

    public User(String string, String string1){
            this.email=string;
            this.password=string1;
    }
    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTotalpoint() { return totalpoint; }

        public void setTotalpoint(String totalpoint) { this.totalpoint = totalpoint; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    }
